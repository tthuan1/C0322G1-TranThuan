package com.example.service.service;

import com.example.service.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showList();

    void create(Product product);

    Product findId(int id);


    void update(int id, Product product);

    void delete(int id);

    void delete1(Product product);

    List<Product> searchByName(Product product);
}
