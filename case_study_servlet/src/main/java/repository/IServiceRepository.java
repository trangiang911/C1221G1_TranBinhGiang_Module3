package repository;

import model.customer.Customer;
import model.service_model.Service;

import java.util.List;

public interface IServiceRepository extends ICrudRepository<Service>{
    @Override
    List<Service> findAll();

    @Override
    void save(Service service);

    @Override
    Service findById(Integer id);
}
