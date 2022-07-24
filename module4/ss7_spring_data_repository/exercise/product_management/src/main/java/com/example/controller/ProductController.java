package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView displayList(@PageableDefault(value = 1) Pageable pageable) {
        Page<Product> productList = productService.showList(pageable);
        return new ModelAndView("list", "productList", productList);
    }


    @GetMapping("/create")
    public String displayCreate(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String displayEdit(@RequestParam int id, Model model) {
        Optional<Product> product = productService.findId(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam int id, @ModelAttribute Product product) {
        productService.update(id, product);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String displayDelete(@RequestParam int id, Model model) {
        Optional<Product> product = productService.findId(id);
        model.addAttribute("product", product);
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product) {
        productService.delete(product);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String displayView(@RequestParam int id, Model model) {
        Optional<Product> product = productService.findId(id);
        model.addAttribute("product", product);
        return "/view";
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("name") String search, @PageableDefault(value = 1) Pageable pageable) {
        Page<Product> productList = productService.search("%" + search + "%", pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }
}
