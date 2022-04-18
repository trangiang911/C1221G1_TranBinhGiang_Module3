package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository extends ICrudRepository<User> {
    @Override
    List<User> findAll();

    @Override
    void save(User user);

    @Override
    boolean update(User user);

    @Override
    List<User> search(String name);
}
