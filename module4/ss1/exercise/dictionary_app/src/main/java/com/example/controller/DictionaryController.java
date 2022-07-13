package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public String display(){
        return "/index";
    }

    @PostMapping("/dictionary")
    public String dictionary(@RequestParam String vnWord, Model model){
        model.addAttribute("esWord", dictionaryService.search(vnWord));
        model.addAttribute("vnWord", vnWord);
        return "/index";
    }
}
