package repository.employee;

import model.Employee;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository{
    private static final String INSERT="INSERT INTO `furama`.`employee` (`name`, `date_of_birth`, `id_card`, `salary`, `phone_number`, `email`, `address`, `position_id`, `education_degree_id`,`create_at`) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,curdate());";
    @Override
    public void create(Employee employee) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);

            preparedStatement.executeUpdate();  // thực thi chương trình với câu lệnh được gán bằng INSERT
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
