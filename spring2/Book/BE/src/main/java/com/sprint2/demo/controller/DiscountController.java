package com.sprint2.demo.controller;

import com.sprint2.demo.models.Discount;
import com.sprint2.demo.services.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/discount")
public class DiscountController {
    @Autowired
    private IDiscountService iDiscountService;

    @GetMapping(value = "")
    public ResponseEntity<List<Discount>> getDiscount() {
        List<Discount> discountList = this.iDiscountService.findAllDiscount();
        if (discountList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discountList,HttpStatus.OK);
    }

}
