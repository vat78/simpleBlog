package ru.vat78.simpleBlog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;
import ru.vat78.simpleBlog.model.User;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class HibernateDataServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    DatabaseService db;

    @Test
    public void testWorkWithUsers(){

        List<User> usersList = db.getAllUsers();
        User testUser = generateUser("test", "test");

        db.saveUser(testUser);

        assertEquals(db.getAllUsers().size(),usersList.size()+1);

        User savedUser = db.getUserById(testUser.getId());

        assertEquals(savedUser.getId(), testUser.getId());

        savedUser.setFullName("new full name");
        db.saveUser(savedUser);

        savedUser.setPassword("");
        assertEquals(db.saveUser(savedUser), false);

        assertEquals(db.saveUser(generateUser("test", "test")), false);

        db.deleteUserById(savedUser.getId());

        assertEquals(db.getAllUsers().size(),usersList.size());
    }

    private User generateUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setFullName(name);
        return user;
    }

}