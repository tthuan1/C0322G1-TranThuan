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

import java.util.List;

@Controller
public class MedicalDeclarationController {

    @Autowired
    private IMedicalDeclarationService medicalDeclarationService;

    @GetMapping("/create")
    public String display(@ModelAttribute MedicalDeclaration medicalDeclaration,Model model){
        model.addAttribute("medicalDeclaration" ,medicalDeclaration);
        model.addAttribute("yearOfBirthList",medicalDeclarationService.yearOfBirthList());
        model.addAttribute("nationalityList",medicalDeclarationService.nationalityList());
        model.addAttribute("vehicleList",medicalDeclarationService.vehicleList());
        return "index";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute MedicalDeclaration medicalDeclaration,Model model){
        medicalDeclarationService.create(medicalDeclaration);
        model.addAttribute("medicalDeclaration" ,medicalDeclaration);
        return "index";
    }

    @GetMapping("/admin")
    public String displayList(@ModelAttribute MedicalDeclaration medicalDeclaration,Model model){
        List<MedicalDeclaration> medicalDeclarationList = medicalDeclarationService.showAll();
        model.addAttribute("medicalDeclarationList", medicalDeclarationList);
        return "list";
    }

    @GetMapping("/update")
    public String displayUpdate(@RequestParam String identityCard , Model model){
        model.addAttribute("yearOfBirthList",medicalDeclarationService.yearOfBirthList());
        model.addAttribute("nationalityList",medicalDeclarationService.nationalityList());
        model.addAttribute("vehicleList",medicalDeclarationService.vehicleList());
        MedicalDeclaration medicalDeclaration = medicalDeclarationService.findIdentityCard(identityCard);
        model.addAttribute("medicalDeclaration" ,medicalDeclaration);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MedicalDeclaration medicalDeclaration, @RequestParam String identityCard){
        medicalDeclarationService.update(identityCard,medicalDeclaration);
        return "redirect:/admin";
    }
}
