package repository.customer;

import model.Customer;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    static List<Customer> customerList = new ArrayList<>();

    private static final String FIND_ALL = "SELECT * FROM furama.customer where delete_at is null or delete_at = 'null';";
    private static final String INSERT = "insert into customer(customer_type_id,`name`,date_of_birth,gender,id_card,phone_number,email,address,create_at)\n" +
            "values (?,?,?,?,?,?,?,?,curdate());";
    private static final String FIND_BY_ID = "select * from customer where id = ?";
    private static final String UPDATE = " UPDATE `furama`.`customer` SET customer_type_id= ?,`name`= ?,date_of_birth= ?," +
            "gender= ?,id_card= ?,phone_number= ?,email= ?,address= ? WHERE (`id` = ?) ; ";
    private static final String DELETE = " UPDATE `furama`.`customer` SET `delete_at` = curdate() WHERE (`id` = ?) ; ";
    private static final String FIND_BY_NAME = "select * from customer where name like ?";

    @Override
    public List<Customer> findAll() {
        customerList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int typeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String deleteAt = resultSet.getString("delete_at");
                String updateAt = resultSet.getString("update_at");
                String createAt = resultSet.getString("create_at");
                customer = new Customer(id, typeId, name, dateOfBirth,
                        gender, idCard, phoneNumber, email, address, deleteAt, updateAt, createAt);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void create(Customer customer) {
        try {
            // Thiết lập kết nối
            Connection connection = new BaseRepository().getConnection();
            // Tạo một câu lệnh bằng cách sử dụng đối tượng kết nối
            //,,,,,email,address,create_at
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, customer.getTypeId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getDateOfBirth());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());

            preparedStatement.executeUpdate();  // thực thi chương trình với câu lệnh được gán bằng INSERT
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer = new Customer();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int typeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String deleteAt = resultSet.getString("delete_at");
                String updateAt = resultSet.getString("update_at");
                String createAt = resultSet.getString("create_at");
                customer = new Customer(id, typeId, name, dateOfBirth,
                        gender, idCard, phoneNumber, email, address, deleteAt, updateAt, createAt);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customer;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = new BaseRepository().getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(Customer customer) {
        try (Connection connection = new BaseRepository().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, customer.getTypeId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getDateOfBirth());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Customer> findByName(String nameSearch) {
        customerList.clear();
        Customer customer = null;
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)) {
            preparedStatement.setString(1, "%" + nameSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                int typeId = resultSet.getInt("customer_type_id");
                String dateOfBirth = resultSet.getString("date_of_birth");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customer = new Customer(id,typeId, name,dateOfBirth,gender,idCard,phoneNumber,email,address);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customerList;
    }
}
