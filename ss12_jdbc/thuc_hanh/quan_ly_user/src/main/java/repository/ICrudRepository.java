package repository;

import model.User;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> findAll();

    void save(E e);

    User findById(Integer id);

    boolean remove(Integer id);

    boolean update(E e);

    List<E> search(String name);
}
