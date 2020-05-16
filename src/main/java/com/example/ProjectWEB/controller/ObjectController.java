package com.example.ProjectWEB.controller;

import com.example.ProjectWEB.entity.Objects;
import com.example.ProjectWEB.enums.Status;
import com.example.ProjectWEB.service.ObjectService;
import com.example.ProjectWEB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class ObjectController {

    @Autowired
    private ObjectService objectService;

    @Autowired
    private UserService userService;

    @RequestMapping("/objects")
    public String found(Model model) {
        model.addAttribute("objects", objectService.findByStatus(Status.FOUND));
        return "found";
    }

    @RequestMapping("/lostObjects")
    public String lost(Model model) {
        model.addAttribute("objects", objectService.findByStatus(Status.LOST));
        return "lost";
    }

    @RequestMapping("/lostForm")
    public String lostForm(Model model){
        model.addAttribute("item", new Objects());
        return "lostForm";
    }

    @RequestMapping("/object/save")
    public String save(@Valid Objects objects, @RequestParam("file") MultipartFile file, Principal principal){
        objects.setUser(userService.findUserByEmail(principal.getName()));
        objectService.save(objects, file);
        return "redirect:/objects";
    }

//    @RequestMapping("/get/{id}")
//    public String get(@PathVariable("id")Long id, Model model){
//        model.addAttribute("item", personService.get(id));
//        return "modals/personModal";
//    }



//
//    @RequestMapping("/delete/{id}")
//    public String delete(@PathVariable("id")Long id){
//        personService.delete(id);
//        return "redirect:/person/index";
//    }

}
