package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;


    @Override
    public Page<Product> showList(Pageable pageable) {
        return productRepository.findAll( pageable);
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> findId(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
         productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Page<Product> search(String name, Pageable pageable) {
        return productRepository.findByName(name,pageable);
    }

}
