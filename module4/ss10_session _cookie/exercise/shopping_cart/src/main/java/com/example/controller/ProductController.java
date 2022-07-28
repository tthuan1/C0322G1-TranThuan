package com.example.controller;

import com.example.model.CartDto;
import com.example.model.Product;
import com.example.model.ProductDto;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @GetMapping("/add/{id}")
    public String addToCard(@PathVariable Integer id, @ModelAttribute("cart") CartDto cartDto) { //lấy session cart ra dùng
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            Product product = productOptional.get();
            BeanUtils.copyProperties(product, productDto);
            //thêm sản phẩm Dto vào giỏ hàng
            cartDto.addProduct(productDto);
        }
        return "redirect:/shop";
    }

    @GetMapping("/delete/{id}")
    public String deleteCart(@PathVariable Integer id, @ModelAttribute("cart") CartDto cartDto){
        Optional<Product> productOptional = productService.findById(id);
        ProductDto productDto = new ProductDto();
        Product product = productOptional.get();
        BeanUtils.copyProperties(product, productDto);
        cartDto.remove(productDto);
        return "redirect:/cart";
    }
}
