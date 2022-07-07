package repository.employee;

import dto.EmployeeDTO;
import model.Customer;
import model.Employee;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDTORepository implements IEmployeeDTORepository {
    static List<EmployeeDTO> employeeDTOList = new ArrayList<>();
    private static final String FIND_ALL = "select e.id,e.name,e.date_of_birth,e.id_card,e.salary,e.phone_number,e.email,e.address,d.name as divisionName,p.name as positionName ,ed.name as educationDegreeName  from employee e\n" +
            "join division d on e.division_id = d.id\n" +
            "join `position` p on e.position_id = p.id\n" +
            "join education_degree ed on e.education_degree_id = ed.id\n" +
            "where e.delete_at is null or e.delete_at=null;";
    private static final String FIND_BY_ID = "select e.id,e.name,e.date_of_birth,e.id_card,e.salary,e.phone_number,e.email,e.address,d.name as divisionName,p.name as positionName ,ed.name as educationDegreeName  from employee e\n" +
            "join division d on e.division_id = d.id\n" +
            "join `position` p on e.position_id = p.id\n" +
            "join education_degree ed on e.education_degree_id = ed.id\n" +
            "where e.delete_at is null and e.id = ? ;";
    private static final String DELETE = " UPDATE `furama`.`employee` SET `delete_at` = curdate() WHERE (`id` = ?) ; ";

    private static final String FIND_BY_NAME = "select e.id,e.name,e.date_of_birth,e.id_card,e.salary,e.phone_number,e.email,e.address,ed.name as educationDegreeName,p.name as positionName ,d.name as divisionName  from employee e\n" +
            "join division d on e.division_id = d.id\n" +
            "join `position` p on e.position_id = p.id\n" +
            "join education_degree ed on e.education_degree_id = ed.id\n" +
            "where e.delete_at is null  and e.name like ? ;";

    private static final String FIND_BY_DIVISION = "select e.id,e.name,e.date_of_birth,e.id_card,e.salary,e.phone_number,e.email,e.address,ed.name as educationDegreeName,p.name as positionName ,d.name as divisionName  from employee e\n" +
            "join division d on e.division_id = d.id\n" +
            "join `position` p on e.position_id = p.id\n" +
            "join education_degree ed on e.education_degree_id = ed.id\n" +
            "where e.delete_at is null  and d.name like ? ;";

    private static final String FIND_BY_POSITION = "select e.id,e.name,e.date_of_birth,e.id_card,e.salary,e.phone_number,e.email,e.address,ed.name as educationDegreeName,p.name as positionName ,d.name as divisionName  from employee e\n" +
            "join division d on e.division_id = d.id\n" +
            "join `position` p on e.position_id = p.id\n" +
            "join education_degree ed on e.education_degree_id = ed.id\n" +
            "where e.delete_at is null  and p.name like ? ;";
    @Override
    public List<EmployeeDTO> findAll() {
        employeeDTOList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();
            EmployeeDTO employeeDTO = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                Double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String positionName = resultSet.getString("divisionName");
                String educationDegreeName = resultSet.getString("positionName");
                String divisionName = resultSet.getString("educationDegreeName");
                employeeDTO = new EmployeeDTO(id,name,dateOfBirth,idCard,salary,phoneNumber,email,address,positionName,educationDegreeName,divisionName);
                employeeDTOList.add(employeeDTO);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO findById(int id) {
        EmployeeDTO employeeDTO = null;
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
                String positionName = resultSet.getString("positionName");
                String educationDegreeName = resultSet.getString("educationDegreeName");
                String divisionName = resultSet.getString("divisionName");
                employeeDTO = new EmployeeDTO(id,name,dateOfBirth,idCard,salary,
                        phoneNumber,email,address,
                        positionName,educationDegreeName,divisionName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeeDTO;
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
    public List<EmployeeDTO> findByName(String nameSearch) {
        employeeDTOList.clear();
        EmployeeDTO employeeDTO = null;
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)) {
            preparedStatement.setString(1, "%"+nameSearch+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                Double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String positionName = resultSet.getString("positionName");
                String educationDegreeName = resultSet.getString("educationDegreeName");
                String divisionName = resultSet.getString("divisionName");
                employeeDTO = new EmployeeDTO(id,name,dateOfBirth,idCard,salary,
                        phoneNumber,email,address,
                        positionName,educationDegreeName,divisionName);
                employeeDTOList.add(employeeDTO);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDTOList;
    }

    @Override
    public List<EmployeeDTO> findByDivision(String nameSearch) {
        employeeDTOList.clear();
        EmployeeDTO employeeDTO = null;
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_DIVISION)) {
            preparedStatement.setString(1, "%"+nameSearch+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                Double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String positionName = resultSet.getString("positionName");
                String educationDegreeName = resultSet.getString("educationDegreeName");
                String divisionName = resultSet.getString("divisionName");
                employeeDTO = new EmployeeDTO(id,name,dateOfBirth,idCard,salary,
                        phoneNumber,email,address,divisionName,
                        positionName,educationDegreeName);
                employeeDTOList.add(employeeDTO);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDTOList;
    }

    @Override
    public List<EmployeeDTO> findByPosition(String nameSearch) {
        employeeDTOList.clear();
        EmployeeDTO employeeDTO = null;
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_POSITION)) {
            preparedStatement.setString(1, "%"+nameSearch+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                Double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String positionName = resultSet.getString("positionName");
                String educationDegreeName = resultSet.getString("educationDegreeName");
                String divisionName = resultSet.getString("divisionName");
                employeeDTO = new EmployeeDTO(id,name,dateOfBirth,idCard,salary,
                        phoneNumber,email,address,
                        positionName,educationDegreeName,divisionName);
                employeeDTOList.add(employeeDTO);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDTOList;
    }
}
