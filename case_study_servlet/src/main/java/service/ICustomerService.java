package service;

import model.customer.Customer;
import model.customer.TypeCustomer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> findAll();

    List<TypeCustomer> subFindAll();

    Map<String,String> save(Customer customer);

    Customer findById(Integer id);

    boolean update(Customer customer);

    boolean remove(Integer id);

    List<Customer> search(String name,String diaChi,String type);
}
