package com.example.controller;

import com.example.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService sandwichService;

    @GetMapping("/sandwich")
    public String display() {
        return "/index";
    }

    @PostMapping("/sandwich")
    public String save(@RequestParam String[] condiment, Model model) {
        String sandwich = sandwichService.save(condiment);
        model.addAttribute("sandwich", sandwich);
        return "/index";
    }
}
