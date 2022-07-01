package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void create(User user);

    void deleteUser(int id);

    User findById(int id);

    void edit(User user);

    void delete(int id);

    List<User> findByName(String name);
}
