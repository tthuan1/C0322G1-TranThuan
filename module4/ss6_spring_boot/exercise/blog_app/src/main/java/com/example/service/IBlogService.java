package com.example.service;

import com.example.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void edit(Blog blog);

    void delete(Integer id);
}
