package com.example.ProjectWEB.controller;


import com.example.ProjectWEB.entity.Objects;
import com.example.ProjectWEB.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestMainController {

    @Autowired
    private ObjectService objectService;

    @PostMapping("/addObject")
    public Objects addObjects(@RequestBody Objects  objects){
        return objectService.save(objects);
    }

    @GetMapping("/getById/{id}")
    public Objects getById(@PathVariable("id") long id){
        return objectService.getById(id);
    }

    @GetMapping("/searchObject")
    public List<Objects> getById(@RequestParam("title") String title){
        System.out.println(title);
        return objectService.searchObject(title);
    }

    @GetMapping("/allObjects")
    public List<Objects> getAll(){
        return objectService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        try {
            return objectService.delete(objectService.getById(id));
        }
        catch (Exception e){
            return e.toString();
        }
    }

}
