package com.example.controller;

import com.example.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @Autowired
    private ICaculatorService caculatorService;

    @GetMapping("/caculator")
    public String display() {
        return "/index";
    }

    @PostMapping("/caculator")
    public String dictionary(@RequestParam String number1, String number2, String calculation, Model model) {
        String result = caculatorService.calculation(number1, number2, calculation);
        model.addAttribute("result", result);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        return "/index";
    }
}
