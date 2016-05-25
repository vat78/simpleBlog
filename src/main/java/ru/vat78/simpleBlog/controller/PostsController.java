package ru.vat78.simpleBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vat78.simpleBlog.model.Post;
import ru.vat78.simpleBlog.services.DatabaseService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class PostsController {

    @Autowired
    DatabaseService blogService;

    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET)
    public String showPost(@PathVariable int postId, Model model){

        model.addAttribute("post",blogService.getPostById(postId));
        return "post";
    }

    @RequestMapping(value="/posts", params="new", method = RequestMethod.GET)
    @Secured("ROLE_USER")
    public String createPost(HttpServletRequest request, Model model){

        Post newPost = new Post();
        newPost.setAuthor(blogService.getUserByName(
                request.getUserPrincipal().getName()));
        model.addAttribute("post", newPost);
        return "post_edit";
    }

    @RequestMapping(value="/posts", params="edit", method = RequestMethod.GET)
    public String editPost(@RequestParam("edit") int postId, HttpServletRequest request, Model model){

        Post post = blogService.getPostById(postId);
        if (post != null &&
                (request.isUserInRole("ROLE_ADMIN") ||
                 request.getUserPrincipal().getName() == post.getAuthor().getName())) {

            model.addAttribute("post", post);
            return "post_edit";
        } else {
            return "redirect:/posts/" + postId;
        }
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public String savePostFromForm(@Valid Post post, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "post_edit";
        }
        if (post.getCreated() == null) post.setCreated(new Date(System.currentTimeMillis()));
        blogService.savePost(post);
        return "redirect:/posts/" + post.getId();
    }

    @RequestMapping(value="/posts", params="delete", method = RequestMethod.GET)
    public String deletePost(@RequestParam("delete") int postId, HttpServletRequest request, Model model){

        Post post = blogService.getPostById(postId);
        if (post != null &&
                (request.isUserInRole("ROLE_ADMIN") ||
                        request.getUserPrincipal().getName() == post.getAuthor().getName())) {
            blogService.deletePostById(postId);
        }
        return "redirect:/";
    }

}
