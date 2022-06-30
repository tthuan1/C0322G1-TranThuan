package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository{

    static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1, "Iphone", 6.0, "xach tay", "?"));
        productList.add(new Product(2, "SamSung", 5.0, "con zin", "?"));
        productList.add(new Product(3, "Bphone", 2.0, "con zin", "?"));
    }

    @Override
    public List<Product> selectAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }


    @Override
    public void update(int id, Product product) {
        productList.set(id,product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id-1);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product item : productList) {
            if (item.getName().contains(name)){
                searchList.add(item);
            }
        }
        return searchList;
    }


}
