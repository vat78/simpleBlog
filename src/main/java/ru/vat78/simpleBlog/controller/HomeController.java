package ru.vat78.simpleBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for home page
 * Created by vat on 12.05.16.
 */

@Controller
public class HomeController {

    @RequestMapping({"/","/home"})
    public String showHomePage(ModelMap map) {
        return "index";
    }
}
