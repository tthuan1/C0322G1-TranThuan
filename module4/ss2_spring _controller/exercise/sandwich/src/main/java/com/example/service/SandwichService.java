package com.example.service;

import com.example.repository.ISandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichService implements ISandwichService {

    @Autowired
    private ISandwichRepository dictionaryRepository;

    @Override
    public String save(String[] condiment) {
        String sandwich = "";

        if (condiment.length == 0) {
            return "Don't!";
        } else {
            for (String item : condiment) {
                sandwich += item + " ";
            }
        }
        return sandwich;
    }
}
