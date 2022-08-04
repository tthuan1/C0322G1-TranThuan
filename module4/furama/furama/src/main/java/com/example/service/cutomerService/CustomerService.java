package com.example.service.cutomerService;

import com.example.model.customer.Customer;
import com.example.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll( pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> search(String name, Pageable pageable) {
        return customerRepository.search(name,pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
