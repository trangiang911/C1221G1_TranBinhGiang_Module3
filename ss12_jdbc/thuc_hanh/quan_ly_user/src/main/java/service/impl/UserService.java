package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository iUserRepository=new UserRepository();
    @Override
    public List<User> findAll() {
        List<User> userList=iUserRepository.findAll();
        return userList;
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return iUserRepository.findById(id);    }

    @Override
    public boolean remove(Integer id) {
        return iUserRepository.remove(id);
    }

    @Override
    public boolean update(User user) {
        return iUserRepository.update(user);
    }

    @Override
    public List<User> search(String name) {
        List<User> userList=iUserRepository.search(name);
        return userList;
    }
}
