package service.customer;

import model.Customer;
import repository.customer.ICustomerRepository;
import repository.customer.CustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
private ICustomerRepository customerRepository=new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.edit(customer);
    }

    @Override
    public List<Customer> findByName(String nameSearch) {
        return customerRepository.findByName(nameSearch);
    }

}
