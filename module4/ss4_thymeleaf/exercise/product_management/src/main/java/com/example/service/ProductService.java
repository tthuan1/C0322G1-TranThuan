package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<Product> showList() {
        return productRepository.showList();
    }

    @Override
    public void create(Product product) {
        productRepository.create( product);
    }

    @Override
    public Product findId(int id) {
        return productRepository.findId( id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update( id,  product);
    }

    @Override
    public void delete( Product product) {
        productRepository.delete(  product);
    }


}
