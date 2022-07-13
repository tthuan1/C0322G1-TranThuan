package repository;

import model.Customer;
import model.HoKhau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoKhauRepository implements IHoKhauRepository {
    static List<HoKhau> hoKhauList = new ArrayList<>();


    private static final String FIND_ALL = "SELECT * FROM bai_thi.ho_khau;";
    private static final String INSERT = "insert into customer(customer_type_id,`name`,date_of_birth,gender,id_card,phone_number,email,address,create_at)\n" +
            "values (?,?,?,?,?,?,?,?,curdate());";
    private static final String FIND_BY_ID = "select * from customer where id = ?";
    private static final String UPDATE = " UPDATE `bai_thi`.`ho_khau` SET `ten_chu_ho` = ?, `ngay_lap_ho_khau` = ?, `dia_chi` = ?  WHERE (`ma_ho_khau` = ?); ";
    private static final String DELETE = " UPDATE `furama`.`customer` SET `delete_at` = curdate() WHERE (`id` = ?) ; ";
    private static final String FIND_BY_NAME = "select * from customer where name like ?";

    @Override
    public List<HoKhau> findAll() {
        hoKhauList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();
            HoKhau hoKhau = null;
            while (resultSet.next()) {
                String maHoKhau = resultSet.getString("ma_ho_khau");
                String tenChuHo = resultSet.getString("ten_chu_ho");
                int soLuong = resultSet.getInt("so_luong");
                String ngayLapHoKhau = resultSet.getString("ngay_lap_ho_khau");

                String diaChiNha = resultSet.getString("dia_chi");

                int maThanhVien = resultSet.getInt("ma_thanh_vien");

                hoKhau = new HoKhau(maHoKhau,tenChuHo,soLuong,ngayLapHoKhau,diaChiNha,maThanhVien);
                hoKhauList.add(hoKhau);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hoKhauList;
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
                customer = new Customer(id, typeId, name, dateOfBirth,
                        gender, idCard, phoneNumber, email, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customer;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = new BaseRepository().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(HoKhau hoKhau) {
        try (Connection connection = new BaseRepository().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, hoKhau.getTenChuHo());
            preparedStatement.setString(2, hoKhau.getNgayLapHoKhau());
            preparedStatement.setString(3, hoKhau.getDiaChiNha());
            preparedStatement.setString(4, hoKhau.getMaHoKhau());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Customer> findByName(String nameSearch) {
        return null;
    }

//    @Override
//    public List<Customer> findByName(String nameSearch) {
//        hoKhauList.clear();
//        Customer customer = null;
//        try (Connection connection = new BaseRepository().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)) {
//            preparedStatement.setString(1, "%" + nameSearch + "%");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = Integer.parseInt(resultSet.getString("id"));
//                String name = resultSet.getString("name");
//                int typeId = resultSet.getInt("customer_type_id");
//                String dateOfBirth = resultSet.getString("date_of_birth");
//                int gender = resultSet.getInt("gender");
//                String idCard = resultSet.getString("id_card");
//                String phoneNumber = resultSet.getString("phone_number");
//                String email = resultSet.getString("email");
//                String address = resultSet.getString("address");
//                customer = new Customer(id,typeId, name,dateOfBirth,gender,idCard,phoneNumber,email,address);
//                hoKhauList.add(customer);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return hoKhauList;
//    }
}
