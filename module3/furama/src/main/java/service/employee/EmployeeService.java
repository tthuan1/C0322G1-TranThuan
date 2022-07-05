package service.employee;

import model.Employee;
import repository.employee.EmployeeRepository;
import repository.employee.IEmployeeRepository;

public class EmployeeService implements IEmployeeService{
    private IEmployeeRepository employeeRepository= new EmployeeRepository();

    @Override
    public void create(Employee employee) {
        employeeRepository.create(employee);
    }
}
