package service;

import model.Customer;
import model.HoKhau;

import java.util.List;

public interface IHoKhauService {

    List<HoKhau> findAll();

    void create(Customer customer);

    Customer findById(int id);

    void delete(int id);

    void edit(HoKhau hoKhau);


    List<Customer> findByName(String nameSearch);
}
