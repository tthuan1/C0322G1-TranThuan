package com.example.service.service;

import com.example.service.model.Product;
import com.example.service.repository.IProductRepository;
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
    public void delete( int id) {
        productRepository.delete(id);
    }

    @Override
    public void delete1(Product product) {
        productRepository.delete1(product);
    }

    @Override
    public List<Product> searchByName(Product product) {
        return productRepository.searchByName( product);
    }


}
