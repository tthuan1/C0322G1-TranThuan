package com.example.service;

import com.example.repository.INameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameService implements INameService {

    @Autowired
    private INameRepository nameRepository;


}
