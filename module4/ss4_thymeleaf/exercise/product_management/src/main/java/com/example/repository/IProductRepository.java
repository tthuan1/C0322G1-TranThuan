package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showList();

    void create(Product product);

    Product findId(int id);

    void update(int id,Product product);

    void delete( Product product);
}
