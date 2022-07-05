package service.customer;

import model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    void create(Customer customer);

    Customer findById(int id);

    void delete(int id);

    void edit(Customer customer);
}
