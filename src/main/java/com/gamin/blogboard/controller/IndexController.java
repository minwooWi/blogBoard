package com.gamin.blogboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String main(){

        return "index";
    }

    @RequestMapping("/about")
    public String about(){

        return "about";
    }

    @RequestMapping("/post")
    public String post(){

        return "post";
    }

    @RequestMapping("/contact")
    public String contact(){

        return "contact";
    }
}
