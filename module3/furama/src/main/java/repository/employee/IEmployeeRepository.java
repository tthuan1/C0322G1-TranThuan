package repository.employee;

import model.Employee;

public interface IEmployeeRepository {
    void create(Employee employee);

    Employee findById(int id);

    void edit(Employee employee);

}
