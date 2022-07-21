package com.example.service;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{


    @Autowired
    private IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findByIdBlog( id);
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.edit(blog.getId(),blog.getContent(),blog.getYear(),blog.getName());
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteBlog(id);
    }
}
