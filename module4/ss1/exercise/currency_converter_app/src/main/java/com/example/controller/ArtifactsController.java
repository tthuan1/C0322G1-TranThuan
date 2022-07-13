package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArtifactsController {

    @GetMapping("/convert")
    public String Artifacts() {
        return "convert";
    }

    @PostMapping("/convert")
    public String Convert(@RequestParam double usd, Model model) {
        double value = usd * 23000;
        model.addAttribute("value", value);
        model.addAttribute("usd", usd);
        return "convert";
    }
}
