package com.example.controller;

import com.example.model.CartDto;
import com.example.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CartController {
    @ModelAttribute("cart")
    public CartDto setupCart(){
        return new CartDto();
    }

    @GetMapping("/cart")
    public ModelAndView showCart(@SessionAttribute(name = "cart", required = false) CartDto cart) {
        return new ModelAndView("/cart", "cart", cart);
    }


}
