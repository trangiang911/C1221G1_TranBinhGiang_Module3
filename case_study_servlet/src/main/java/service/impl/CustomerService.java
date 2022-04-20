package service.impl;

import model.customer.Customer;
import model.customer.TypeCustomer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository iCustomerRepository=new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList=iCustomerRepository.findAll();
        return customerList;
    }

    @Override
    public List<TypeCustomer> subFindAll() {
        List<TypeCustomer> typeCustomerList=iCustomerRepository.subFindAll();
        return typeCustomerList;
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public boolean update(Customer customer) {
        return iCustomerRepository.update(customer);
    }

    @Override
    public boolean remove(Integer id) {
        return iCustomerRepository.remove(id);
    }

    @Override
    public List<Customer> search(String name, String diaChi, String type) {
        return iCustomerRepository.search(name,diaChi,type);
    }


}
