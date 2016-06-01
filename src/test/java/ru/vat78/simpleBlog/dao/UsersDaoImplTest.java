package ru.vat78.simpleBlog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import ru.vat78.simpleBlog.model.User;

public class UsersDaoImplTest extends EntityDaoImplTest {

    private int id;

    @Autowired
    UsersDao usersDao;

    @Test
    public void saveUser() throws Exception {

        User user = getTestUser();
        usersDao.save(user);
        id = user.getId();
    }

    /*
    @Test
    public void deleteUserById() throws Exception {
        usersDao.deleteUserById(id);
    }
    */

    private User getTestUser(){

        User user = new User();
        user.setName("test");
        user.setPassword("password");
        user.setFullName("test user");
        return user;
    }

}