package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;

import java.util.Calendar;
import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();

    void save(Category category);

    Category findById(Integer id);
}
