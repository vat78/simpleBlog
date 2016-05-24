package ru.vat78.simpleBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vat78.simpleBlog.model.Post;
import ru.vat78.simpleBlog.model.User;
import ru.vat78.simpleBlog.services.DatabaseService;

import java.util.Date;

/**
 * Controller for home page
 * Created by vat on 12.05.16.
 */

@Controller
public class HomeController {

    @Autowired
    DatabaseService blogService;

    @RequestMapping({"/","/home"})
    public String showHomePage(ModelMap map) {

        makeFakeData();
        map.addAttribute("posts",blogService.getLastPosts(5));
        //String userName = blogService.getLastPosts(5).get(1).getAuthor().getName();
        return "index";
    }

    private void makeFakeData() {


        blogService.checkAdmin();

        /*
        if (blogService.getLastPosts(5).size() < 1) {
            User testUser = new User();
            testUser.setName("vasya");
            testUser.setPassword("12345");
            testUser.setFullName("Vasya Pupkin");

            blogService.createNewUser(testUser);

            Post newPost = new Post();
            newPost.setAuthor(testUser);
            newPost.setTitle("Test post");
            newPost.setCreated(new Date(System.currentTimeMillis()));
            newPost.setText("flkdg dfgkl jfds dsflgj ';gdfj ';fdg ;ljfd;gs ");
            //blogService.savePost(newPost);
        }
        */
    }


}
