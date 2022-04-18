package service;

import model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    void save(User user);

    User findById(Integer id);

    boolean remove(Integer id);

    boolean update( User user);

    List<User> search(String name);
}
