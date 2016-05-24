package ru.vat78.simpleBlog.dao;

import ru.vat78.simpleBlog.model.User;

import java.util.List;

public interface UsersDao {

    void saveUser(User user);

    void deleteUserById(int id);

    User getUserById(int id);

    User findByUsername(String username);

    List<User> getAllUsers();
}
