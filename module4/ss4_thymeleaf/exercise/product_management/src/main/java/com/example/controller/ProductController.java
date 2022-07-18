package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("" )
    public String displayList(@ModelAttribute Product product, Model model){
        model.addAttribute("productList",productService.showList());
        return "/list";
    }


    @GetMapping("/create")
    public String displayCreate(@ModelAttribute Product product, Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, Model model){
        productService.create(product);
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String displayEdit( @RequestParam int id,Model model){
        Product product=productService.findId(id);
        model.addAttribute("product",product);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit( @RequestParam  int id,@ModelAttribute Product product){
        productService.update(id,product);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete( @ModelAttribute Product product){
        productService.delete(product);
        return "redirect:/";
    }

}
