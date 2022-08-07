package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.Customer;
import com.example.model.CustomerType;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypeList")
    private List<CustomerType> customerTypeList(){
        return this.customerTypeService.findAll();
    }

    @GetMapping("/customer")
    public String showCustomer(@RequestParam(value = "nameSearch", defaultValue = "") String search,@PageableDefault(value = 5,sort = "id",direction = Sort.Direction.DESC) Pageable pageable, Model model){
        Page<Customer> customerList = customerService.search(search, pageable);
        model.addAttribute("nameSearch",search);
        model.addAttribute("customerList",customerList);
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public String showFormCreate(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        return "customer/create";
    }
    @PostMapping("/customer/create")
    public String create(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
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
        return "customer/edit";
    }

    @PostMapping("/customer/edit")
    public String editCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes,BindingResult bindingResult){
        customerService.edit(customer);
        redirectAttributes.addFlashAttribute("mess","Edit Successfully!");
        return "redirect:/customer";
    }

}