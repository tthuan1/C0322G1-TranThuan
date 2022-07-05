package repository;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    static List<Product> productList = new ArrayList<>();
    private static final String SELECT_ALL = "SELECT * FROM product";
    private static final String CREATE = "INSERT INTO `product` (`name`, `price`, `describe`, `producer`) VALUES (?, ?, ?, ?);";
    private static final String FIND_BY_ID = "select * from product where id = ?;";
    private static final String UPDATE = "UPDATE `product` SET `name` = ?, `price` = ?, `describe` = ?, `producer` = ? WHERE (`id` = ?);";
    private static final String DELETE = "UPDATE `product` SET `delete` = ? WHERE (`id` = ?);";

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
                String describe = resultSet.getString("describe");
                String producer = resultSet.getString("producer");
                product = new Product(id, name, price, describe, producer);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public void add(Product product) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescribe());
            preparedStatement.setString(4, product.getProducer());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Product product) {
        try (Connection connection = new BaseRepository().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescribe());
            preparedStatement.setString(4, product.getProducer());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        productList.clear();
        Product product = new Product();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String describe = resultSet.getString("describe");
                String producer = resultSet.getString("producer");
                product = new Product(name, price, describe, producer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void delete( Product product) {
        try (Connection connection = new BaseRepository().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1, "curdate()");
            preparedStatement.setInt(2, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product item : productList) {
            if (item.getName().contains(name)) {
                searchList.add(item);
            }
        }
        return searchList;
    }


}
