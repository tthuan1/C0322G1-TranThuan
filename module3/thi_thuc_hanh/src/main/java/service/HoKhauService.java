package service;

import model.Customer;
import model.HoKhau;
import repository.HoKhauRepository;
import repository.IHoKhauRepository;

import java.util.List;

public class HoKhauService implements IHoKhauService {
private IHoKhauRepository hoKhauRepository =new HoKhauRepository();
    @Override
    public List<HoKhau> findAll() {
        return hoKhauRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
        hoKhauRepository.create(customer);
    }

    @Override
    public Customer findById(int id) {
        return hoKhauRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        hoKhauRepository.delete(id);
    }

    @Override
    public void edit(HoKhau hoKhau) {
        hoKhauRepository.edit(hoKhau);
    }

    @Override
    public List<Customer> findByName(String nameSearch) {
        return hoKhauRepository.findByName(nameSearch);
    }

}
