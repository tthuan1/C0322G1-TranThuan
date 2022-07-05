package service.employee;

import dto.EmployeeDTO;
import repository.employee.IEmployeeDTORepository;
import repository.employee.EmployeeDTORepository;

import java.util.List;

public class EmployeeDTOService implements IEmployeeDTOService {
    private IEmployeeDTORepository employeeRepository=new EmployeeDTORepository();
    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll();
    }
}
