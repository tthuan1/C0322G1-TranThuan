package com.example.controller;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;


    @GetMapping("/customer")
    public String showCustomer(@PageableDefault(value = 7,sort = "id",direction = Sort.Direction.DESC) Pageable pageable, Model model){
        Page<Customer> customerList = customerService.findAll(pageable);
        List<CustomerType> customerTypeList=customerTypeService.findAll();
        model.addAttribute("customerList",customerList);
        model.addAttribute("customerTypeList",customerTypeList);
        return "/customer/list";
    }

    @GetMapping("/customer/create")
    public String showCreateCustomer(Model model){
        List<CustomerType> customerTypeList=customerTypeService.findAll();
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerTypeList",customerTypeList);
        return "/customer/create";
    }

    @PostMapping("/customer/create")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Create Successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/customer/delete/{id}")
    public String showDeleteCustomer(@PathVariable int id, RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Delete Successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/customer/edit/{id}")
    public String ShowEditCustomer(@PathVariable int id, Model model){
        Optional<Customer> customer=customerService.findById(id);
        model.addAttribute("customer",customer);
        List<CustomerType> customerTypeList=customerTypeService.findAll();
        model.addAttribute("customerTypeList",customerTypeList);
        return "/customer/edit";
    }

    @PostMapping("/customer/edit")
    public String editCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
        customerService.edit(customer);
        redirectAttributes.addFlashAttribute("mess","Edit Successfully!");
        return "redirect:/customer";
    }

    @PostMapping("/customer/search")
    public String search(@RequestParam("name") String search,Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customerList = customerService.search("%" + search + "%", pageable);
        List<CustomerType> customerTypeList=customerTypeService.findAll();
        model.addAttribute("customerList",customerList);
        model.addAttribute("customerTypeList",customerTypeList);
        return "/customer/list";
    }


}
