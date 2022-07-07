package repository.employee;

import model.Customer;
import model.Employee;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository{
    private static final String INSERT=" INSERT INTO `furama`.`employee` (`name`, `date_of_birth`, `id_card`, `salary`, `phone_number`, `email`, `address`, `position_id`, `education_degree_id`,`division_id`,`create_at`) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, curdate()); ";

    private static final String FIND_BY_ID="select * from `employee` where id = ?";
    private static final String UPDATE="UPDATE `furama`.`employee` SET `name` = ?, `date_of_birth` = ?, `id_card` = ?, `salary` = ?, `phone_number` = ?, `email` = ?, `address` = ?, `position_id` = ?, `education_degree_id` = ?,`division_id` = ?  WHERE (`id` = ?);";


    @Override
    public void create(Employee employee) {
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = new Employee();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                Double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Integer positionId = resultSet.getInt("position_id");
                Integer educationDegreeId = resultSet.getInt("education_degree_id");
                Integer divisionId = resultSet.getInt("division_id");

                employee = new Employee(id,name,dateOfBirth,idCard,salary,phoneNumber,email,address,positionId,educationDegreeId,divisionId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employee;
    }

    @Override
    public void edit(Employee employee) {
        try (Connection connection = new BaseRepository().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setInt(11, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
