package services;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> display();
    void add(Customer customer);
    void edit(Integer id);
    void del(Integer id);
    Customer find(Integer id);
}
