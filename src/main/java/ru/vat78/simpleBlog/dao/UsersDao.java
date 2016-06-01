package ru.vat78.simpleBlog.dao;

import ru.vat78.simpleBlog.model.User;

import java.util.List;

public interface UsersDao {

    void save(User user);

    void add(User user);

    void deleteById(int id);

    User findById(int id);

    User findByUsername(String username);

    List<User> getAll();

}
