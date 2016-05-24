package ru.vat78.simpleBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vat78.simpleBlog.model.User;
import ru.vat78.simpleBlog.services.DatabaseService;

import javax.validation.Valid;
import java.util.List;

/**
 * Show user's info and posts
 */

@Controller
public class UsersController {

    @Autowired
    DatabaseService blogService;

    //@RequestMapping(value="/users/{username}", method=RequestMethod.GET)
    @RequestMapping(value="/users", params="id", method = RequestMethod.GET)
    public String userInfo(@RequestParam("id") int userId, Model model){

        User user = blogService.getUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("posts", user.getUserPosts());
        return "user_info";
    }

    @RequestMapping(value="/users", params="new", method = RequestMethod.GET)
    public String createUser(Model model){

        model.addAttribute("user", new User());
        return "user_edit";
    }

    @RequestMapping(value="/users", params="edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("edit") int userId, Model model){

        User u = blogService.getUserById(userId);
        if (u != null) {
            model.addAttribute("user", u);
            return "user_edit";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveUserFromFrom(@Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "user_edit";
        }
        if (blogService.saveUser(user)) {
            return "redirect:/users?id=" + user.getId();
        } else {
            bindingResult.rejectValue("name", "error.user", "User already exists");
            return "user_edit";
        }
    }

    @RequestMapping(value="/users", params="delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("delete") int userId, Model model){
        User u = blogService.getUserById(userId);
        if (u != null) {
            blogService.deleteUserById(userId);
        }
        return "redirect:/";
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String usersList(Model model) {

        List<User> ul = blogService.getAllUsers();
        model.addAttribute("users", ul);
        return "admin";
    }
}
