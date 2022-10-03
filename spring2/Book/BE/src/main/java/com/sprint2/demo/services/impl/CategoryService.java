package com.sprint2.demo.services.impl;

import com.sprint2.demo.models.Category;
import com.sprint2.demo.repository.ICategoryRepository;
import com.sprint2.demo.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return this.iCategoryRepository.findAll();
    }
}
