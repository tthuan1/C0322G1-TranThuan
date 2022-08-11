package com.example.service;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void remove(int id);

    Optional<Customer> findById(int id);

    void edit(Customer customer);

    Page<Customer> search(String name, Pageable pageable);

    List<Customer> findAll();

}
