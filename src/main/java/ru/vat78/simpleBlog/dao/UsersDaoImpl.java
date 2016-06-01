package ru.vat78.simpleBlog.dao;


import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vat78.simpleBlog.model.User;

import java.util.List;

@Transactional
@Repository("usersDao")
public class UsersDaoImpl extends AbstractDao<User> implements UsersDao{

    public User findByUsername(String username) {

        Session session = getSession();
        List<User> users = getCriteria().add(Restrictions.eq("name", username)).list();
        if (users.size()>0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public void deleteById(int id) {
        User user = new User();
        user.setId(id);
        delete(user);
    }

    Class<User> getEntityClass() {
        return User.class;
    }

}
