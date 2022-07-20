package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Iphone", 2400000.0, "100%", "VN"));
        productList.add(new Product(2, "Bphone", 1400000.0, "100%", "VN"));
        productList.add(new Product(3, "Cphone", 400000.0, "90%", "VN"));
        productList.add(new Product(4, "Dphone", 2400000.0, "100%", "VN"));
        productList.add(new Product(5, "Ephone", 1400000.0, "100%", "VN"));
        productList.add(new Product(6, "Fphone", 400000.0, "90%", "china"));
    }


    @Override
    public List<Product> showList() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public Product findId(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (Product temp : productList) {
            if (temp.getId() == id) {
                temp.setName(product.getName());
                temp.setPrice(product.getPrice());
                temp.setDescribe(product.getDescribe());
                temp.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public void delete(int id) {
        productList.removeIf(product -> product.getId() == id);
    }

    @Override
    public void delete1(Product product) {
        productList.remove(product);
    }

    @Override
    public List<Product> searchByName(Product product) {
        List<Product> productListSearch = new ArrayList<>();
        for (Product temp : productList) {
            if (temp.getName().contains(product.getName())) {
                productListSearch.add(temp);
            }
        }
        return productListSearch;
    }

}
