package com.sprint2.demo.services.impl;

import com.sprint2.demo.models.Author;
import com.sprint2.demo.repository.IAuthorRepository;
import com.sprint2.demo.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository iAuthorRepository;
    @Override
    public List<Author> findAllAuthor() {
        return this.iAuthorRepository.findAll();
    }
}
