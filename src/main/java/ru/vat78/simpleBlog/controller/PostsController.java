package ru.vat78.simpleBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vat78.simpleBlog.dao.PostsDao;

@Controller
public class PostsController {

    @Autowired
    PostsDao posts;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String showPost(@RequestParam("id") int postId, Model model){

        model.addAttribute("post",posts.findById(postId));
        return "post";
    }
}
