package ru.vat78.simpleBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vat78.simpleBlog.dao.UsersDao;
import ru.vat78.simpleBlog.model.User;

/**
 * Show user's info and posts
 */

@Controller
public class UsersController {

    @Autowired
    UsersDao users;

    //@RequestMapping(value="/users/{username}", method=RequestMethod.GET)
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public String userInfo(@RequestParam("id") int userId, Model model){

        User user = users.getUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("posts", user.getUserPosts());
        return "user_info";
    }
}
