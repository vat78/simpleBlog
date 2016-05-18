package ru.vat78.simpleBlog.dao;

import org.springframework.stereotype.Repository;
import ru.vat78.simpleBlog.model.User;

@Repository("usersDao")
public class UsersDaoImpl extends AbstractDao implements UsersDao {

    public void saveUser(User user) {
        getSession().persist(user);

    }

    public void deleteUserById(int id) {
        deleteUser(getUserById(id));
    }

    private void deleteUser(User user) {
        getSession().delete(user);
    }

    private User getUserById(int id) {
        return getSession().get(User.class, id);
    }
}
