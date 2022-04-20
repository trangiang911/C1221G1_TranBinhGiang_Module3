package repository;

import model.customer.Customer;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> findAll();

    void save(E e);

    E findById(Integer id);

}
