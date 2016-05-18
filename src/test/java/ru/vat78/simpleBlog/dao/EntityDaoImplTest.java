package ru.vat78.simpleBlog.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import ru.vat78.simpleBlog.config.HibernateTestConfiguration;


@ContextConfiguration(classes = { HibernateTestConfiguration.class })
public abstract class EntityDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

}