package com.example.ProjectWEB.controller;

import com.example.ProjectWEB.repository.ObjectRepository;
import com.example.ProjectWEB.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    ObjectService objectService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
    @RequestMapping("/lostTable")
    public String lostAdmin(){
        return "lostTable";
    }
    @RequestMapping("/foundTable")
    public String foundAdmin(){
        return "foundTable";
    }
    @RequestMapping("/adminProfile")
    public String adminProfile(){
        return "user";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }


}
