package ru.vat78.simpleBlog.dao;

import ru.vat78.simpleBlog.model.User;

public interface UsersDao {

    void saveUser(User user);

    void deleteUserById(int id);

    User getUserById(int id);

}
