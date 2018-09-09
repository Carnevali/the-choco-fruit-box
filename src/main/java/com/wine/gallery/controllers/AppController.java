package com.wine.gallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Controller
public class AppController {
    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","The ChocoFruit Box");
        return "index";
    }

    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }
}