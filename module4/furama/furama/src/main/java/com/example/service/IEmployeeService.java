package com.example.service;

import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Optional<Employee> findById(int id);

    void remove(int id);

    void edit(Employee employee);

    void save(Employee employee);

    List<Employee> findAll();
}
