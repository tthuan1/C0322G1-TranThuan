package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> selectAll();

    void add(Product product);


    void update(Product product);

    Product findById(int id);

    void delete( Product product);

    List<Product> findByName(String name);
}
