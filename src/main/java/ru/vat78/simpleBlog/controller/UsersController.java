package ru.vat78.simpleBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vat78.simpleBlog.model.User;
import ru.vat78.simpleBlog.services.DatabaseService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Show user's info and posts
 */

@Controller
public class UsersController {

    private final static int PAGE_SIZE = 5;

    @Autowired
    DatabaseService blogService;

    @RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
    public String userInfo(@PathVariable int userId, @RequestParam(required = false) Integer page, Model model){

        if (page == null) page = 0;
        User user = blogService.getUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("posts", blogService.getPostsByAuthor(user,page,PAGE_SIZE));

        boolean hasNext = (page+1) * PAGE_SIZE < blogService.getPostsCount(user);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("hasPrevious", page>0);
        return "user";
    }

    @RequestMapping(value="/users", params="new", method = RequestMethod.GET)
    @Secured("ROLE_ADMIN")
    public String createUser(Model model){

        model.addAttribute("user", new User());
        return "user_edit";
    }

    /**
     *  Only user himself or users with role ADMIN can edit user's parametrs
     * @param userId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/users", params="edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("edit") int userId, HttpServletRequest request, Model model){

        User u = blogService.getUserById(userId);
        if (u != null && (
                request.isUserInRole("ROLE_ADMIN") ||
                request.getUserPrincipal().getName() == u.getName())) {
            model.addAttribute("user", u);
            return "user_edit";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveUserFromForm(@Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "user_edit";
        }

        if (blogService.saveUser(user)) {
            return "redirect:/users/" + user.getId();
        } else {
            bindingResult.rejectValue("name", "error.user", "User already exists");
            return "user_edit";
        }
    }

    /**
     *  Delete user from database
     *  This operation can make only user himself or users with ADMIN role
     *  If user delete himself, system will make logout after deletion
     * @param userId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/users", params="delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("delete") int userId, HttpServletRequest request, Model model){
        User u = blogService.getUserById(userId);
        if (u != null && (
                request.isUserInRole("ROLE_ADMIN") ||
                request.getUserPrincipal().getName() == u.getName())) {
            blogService.deleteUserById(userId);

            if (request.getUserPrincipal().getName() == u.getName()) {
                try {
                    request.logout();
                } catch (Exception ignored) {}
            } else {
                return  "redirect:/admin";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String usersList(Model model) {

        List<User> ul = blogService.getAllUsers();
        model.addAttribute("users", ul);
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid credentials");
        }
        if (logout != null) {
            model.addAttribute("message", "logged out successfully");
        }
        return "login";
    }
}
