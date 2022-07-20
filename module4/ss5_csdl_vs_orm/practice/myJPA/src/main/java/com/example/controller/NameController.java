package com.example.controller;

import com.example.service.INameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NameController {

    @Autowired
    private INameService nameService;

    @GetMapping("/nameLink")
    public String display(){
        return "/index";
    }

    @PostMapping("/nameLink")
    public String dictionary(@RequestParam String name,Model model){
        return "/index";
    }
}
