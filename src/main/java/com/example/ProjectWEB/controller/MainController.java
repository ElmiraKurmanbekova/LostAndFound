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

    @Autowired
    ObjectRepository objectRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/events")
    public String blog(){
        return "blog";
    }

    @RequestMapping("/objects")
    public String found(Model model) {
        model.addAttribute("objects", objectRepository.findByStatus("found"));
        return "courses";
    }
    @RequestMapping("/lostObjects")
    public String lost(Model model) {
        model.addAttribute("objects", objectRepository.findByStatus("lost"));
        return "lost";
    }

}
