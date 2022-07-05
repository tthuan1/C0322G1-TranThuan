package service.customer;

import model.CustomerType;
import repository.customer.ICustomerTypeRepository;
import repository.customer.CustomerTypeRepository;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository=new CustomerTypeRepository();
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
