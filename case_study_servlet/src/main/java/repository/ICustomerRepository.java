package repository;

import model.customer.Customer;
import model.customer.TypeCustomer;

import java.util.List;

public interface ICustomerRepository extends ICrudRepository<Customer> {
    @Override
    List<Customer> findAll();

    List<TypeCustomer> subFindAll();

    @Override
    void save(Customer customer);

    @Override
    Customer findById(Integer id);


    boolean update(Customer customer);


    boolean remove(Integer id);


    List<Customer> search(String name, String diaChi, String type);
}
