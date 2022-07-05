package service.employee;

import dto.EmployeeDTO;
import model.Employee;

import java.util.List;

public interface IEmployeeDTOService {
    List<EmployeeDTO> findAll();
}
