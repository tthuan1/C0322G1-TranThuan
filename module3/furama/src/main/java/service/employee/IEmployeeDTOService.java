package service.employee;

import dto.EmployeeDTO;
import model.Employee;

import java.util.List;

public interface IEmployeeDTOService {
    List<EmployeeDTO> findAll();

    EmployeeDTO findById(int id);

    void delete(int id);

    List<EmployeeDTO> findByName(String nameSearch);

    List<EmployeeDTO> findByDivision(String nameSearch);

    List<EmployeeDTO> findByPosition(String nameSearch);
}
