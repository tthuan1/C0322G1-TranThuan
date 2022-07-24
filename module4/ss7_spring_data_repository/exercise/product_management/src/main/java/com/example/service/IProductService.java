package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Page<Product> showList(Pageable pageable);

    void create(Product product);

    Optional<Product> findId(Integer id);


    void update(int id, Product product);

    void delete(Product product);

    Page<Product> search(String name, Pageable pageable);
}
