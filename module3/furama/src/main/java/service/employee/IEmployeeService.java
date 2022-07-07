package service.employee;

import model.Employee;

public interface IEmployeeService {
    void create(Employee employee);

    Employee findById(int id);

    void edit(Employee employee);

}
