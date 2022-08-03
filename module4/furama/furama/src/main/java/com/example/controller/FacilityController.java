package com.example.controller;

import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.service.facilityService.IFacilityService;
import com.example.service.facilityService.IFacilityTypeService;
import com.example.service.facilityService.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/facility")
    public String showFacility(Model model,@PageableDefault(value = 5) Pageable pageable){
        Page<Facility> facilityList=facilityService.findAll(pageable);
        model.addAttribute("facilityList",facilityList);
        return "facility/list";
    }

    @GetMapping("/facility/create")
    public String showFacilityCreate(Model model){
        List<FacilityType> facilityTypeList=facilityTypeService.findAll();
        List<RentType> rentTypeList=rentTypeService.findAll();
        model.addAttribute("facilityTypeList",facilityTypeList);
        model.addAttribute("rentTypeList",rentTypeList);
        model.addAttribute("facility",new Facility());
        return "facility/create";
    }

    @PostMapping("/facility/create")
    public String createFacility(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","create facility "+ facility.getName() +" Successfully!" );
        return "redirect:/facility";
    }

    @GetMapping("/facility/delete/{id}")
    public String deleteFacility(@PathVariable int id, RedirectAttributes redirectAttributes){
        facilityService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Delete Successfully!" );
        return "redirect:/facility";
    }

}