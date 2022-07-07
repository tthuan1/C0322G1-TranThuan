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

    @Override
    public EmployeeDTO findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }

    @Override
    public List<EmployeeDTO> findByName(String nameSearch) {
        return employeeRepository.findByName(nameSearch);
    }

    @Override
    public List<EmployeeDTO> findByDivision(String nameSearch) {
        return employeeRepository.findByDivision(nameSearch);
    }

    @Override
    public List<EmployeeDTO> findByPosition(String nameSearch) {
        return employeeRepository.findByPosition(nameSearch);
    }
}
