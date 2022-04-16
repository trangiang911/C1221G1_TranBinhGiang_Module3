package repository;

import model.Product;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> findAll();
    void save(E e);
    E findById(Integer id);
    void update(Integer id, Product product);
    void remove(Integer id);
    List<E> search(String name);
}
