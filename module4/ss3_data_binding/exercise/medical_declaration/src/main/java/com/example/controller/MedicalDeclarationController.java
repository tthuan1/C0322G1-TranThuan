package com.example.controller;

import com.example.model.MedicalDeclaration;
import com.example.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MedicalDeclarationController {

    @Autowired
    private IMedicalDeclarationService nameService;

    @GetMapping("")
    public String display(@ModelAttribute MedicalDeclaration medicalDeclaration,Model model){
        model.addAttribute("medicalDeclaration" ,medicalDeclaration);

        return "index";
    }

    @PostMapping("/nameLink")
    public String dictionary(@RequestParam String name,Model model){
        return "/index";
    }
}
