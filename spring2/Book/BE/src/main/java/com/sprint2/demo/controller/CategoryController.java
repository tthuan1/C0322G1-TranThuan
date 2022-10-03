package com.sprint2.demo.controller;

import com.sprint2.demo.models.Category;
import com.sprint2.demo.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/category")
@RestController
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping(value = "")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categories = this.iCategoryService.findAllCategory();
        if (categories == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
