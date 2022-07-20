package com.example.service;

import com.example.service.model.Product;
import com.example.service.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String displayDelete( @RequestParam int id,Model model){
        Product product=productService.findId(id);
        model.addAttribute("product",product);
        return "/delete";
    }

//    @PostMapping("/delete")
//    public String delete(@ModelAttribute Product product){
//        productService.delete(product.getId());
//        return "redirect:/";
//    }
    @PostMapping("/delete")
    public String delete1(@ModelAttribute Product product){
        productService.delete1(product);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String displayView( @RequestParam int id,Model model){
        Product product=productService.findId(id);
        model.addAttribute("product",product);
        return "/view";
    }

    @GetMapping("/search")
    public String search(Product product, Model model) {
        model.addAttribute("productList", productService.searchByName(product));
        return "/list";
    }

}
