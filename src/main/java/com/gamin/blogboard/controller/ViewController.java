package com.gamin.blogboard.controller;

import com.gamin.blogboard.services.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String postList() {
        return "index";
    }

    @RequestMapping("/post")
    public String post(){

        return "post";
    }
//
//    @RequestMapping("/about")
//    public String about(){
//
//        return "about";
//    }

//
//    @RequestMapping("/contact")
//    public String contact(){
//
//        return "contact";
//    }
}
