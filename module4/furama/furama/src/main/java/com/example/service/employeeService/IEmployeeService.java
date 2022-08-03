package com.example.service.employeeService;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Optional<Employee> findById(int id);

    void remove(int id);

    void edit(Employee employee);

    void save(Employee employee);
}
