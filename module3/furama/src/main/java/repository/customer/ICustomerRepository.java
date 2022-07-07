package repository.customer;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    void create(Customer customer);

    Customer findById(int id);

    void delete(int id);

    void edit(Customer customer);

    List<Customer> findByName(String nameSearch);
}
