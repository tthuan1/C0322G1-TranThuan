package com.example.service;

import com.example.module.User;

import java.util.List;

public interface IUserService {
    public void save(User user);
    List<User> findAll();
}
