package service;

import model.Product;

import java.util.List;

public interface IProductService {


    List<Product> selectAll();

    void add(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void delete(int id);

    List<Product> findByName(String name);
}
