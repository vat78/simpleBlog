package ru.vat78.simpleBlog.dao;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.vat78.simpleBlog.model.User;
import ru.vat78.simpleBlog.services.UsersRepository;

import java.util.List;

@Repository("usersDao")
public class UsersDaoImpl extends AbstractDao implements UsersDao, UsersRepository {

    public void saveUser(User user) {
        Session session = getSession();
        session.persist(user);
        session.flush();
    }

    public void deleteUserById(int id) {
        deleteUser(getUserById(id));
    }

    private void deleteUser(User user) {
        getSession().delete(user);
    }

    public User getUserById(int id) {
        return getSession().get(User.class, id);
    }

    public User findByUsername(String username) {

        Session session = getSession();
        List<User> users = session.createCriteria(User.class,"name = " + username).list();
        if (users.size()>0) {
            return users.get(1);
        } else {
            return null;
        }

    }

    public <S extends User> S save(S s) {
        saveUser(s);
        return s;
    }

    public <S extends User> Iterable<S> save(Iterable<S> iterable) {

        for (User user: iterable) {
            saveUser(user);
        }
        return iterable;
    }

    public User findOne(Integer id) {
        return getUserById(id);
    }

    public boolean exists(Integer id) {
        return (getUserById(id) != null);
    }

    public Iterable<User> findAll() {
        return null;
    }

    public Iterable<User> findAll(Iterable<Integer> iterable) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Integer id) {
        deleteUserById(id);
    }

    public void delete(User user) {
        deleteUser(user);
    }

    public void delete(Iterable<? extends User> iterable) {
        for(User user : iterable)
            deleteUser(user);
    }

    public void deleteAll() {
        for(User user : findAll())
            deleteUser(user);
    }
}
