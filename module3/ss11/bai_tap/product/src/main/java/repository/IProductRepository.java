package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> selectAll();

    void add(Product product);


    void update(int id, Product product);

    Product findById(int id);

    void delete(int id);

    List<Product> findByName(String name);
}
