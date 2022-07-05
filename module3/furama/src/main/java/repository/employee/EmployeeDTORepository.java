package repository.employee;

import dto.EmployeeDTO;
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
            "where e.delete_at is null;";
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
}
