package repository;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    static List<Product> productList = new ArrayList<>();
    private static final String SELECT_ALL = "SELECT * FROM product";

    @Override
    public List<Product> selectAll() {
        productList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String country = resultSet.getString("country");
                String describe = resultSet.getString("describe");
                String producer = resultSet.getString("producer");
                product = new Product(id, name, price, describe,producer);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
