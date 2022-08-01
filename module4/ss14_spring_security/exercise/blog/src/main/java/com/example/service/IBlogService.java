package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
//    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void edit(Blog blog);

    void delete(int id);

    Page<Blog> findAll(Pageable pageable);

    void remove(int id);
}
