package repository.employee;

import dto.EmployeeDTO;
import model.Employee;

import java.util.List;

public interface IEmployeeDTORepository {
    List<EmployeeDTO> findAll();
}
