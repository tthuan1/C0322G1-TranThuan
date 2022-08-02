package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/c0322g1")
    public String showLoginPage() {
        return "myLogin";
    }

}
