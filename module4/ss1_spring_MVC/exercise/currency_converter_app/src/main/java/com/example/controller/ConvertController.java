package com.example.controller;

import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    private IConvertService convert;

    @GetMapping("/convert")
    public String Artifacts() {
        return "convert";
    }

    @PostMapping("/convert")
    public String Convert(@RequestParam double usd, Model model) {
        double value = convert.convert(usd);
        model.addAttribute("value", value);
        model.addAttribute("usd", usd);
        return "convert";
    }
}
