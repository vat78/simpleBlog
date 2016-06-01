package ru.vat78.simpleBlog.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.vat78.simpleBlog.model.DBEntity;

import java.util.List;

public abstract class AbstractDao<T extends DBEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public T findById(int id) {
        return getSession().get(getEntityClass(), id);
    }

    @Transactional(readOnly = false)
    public void save(T entity){
        getSession().merge(entity);
    }

    @Transactional(readOnly = false)
    public void add(T entity){
        getSession().persist(entity);
    }

    @Transactional(readOnly = true)
    public List<T> getAll(){
        return getSession().createCriteria(getEntityClass(), "id > 0").list();
    }

    @Transactional
    public void delete(T entity){
        getSession().delete(entity);
    }

    @Transactional(readOnly = true)
    public int getCount() {
        Criteria criteria = getCriteria();
        return (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    abstract Class<T> getEntityClass();

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    protected Criteria getCriteria(){
        return getSession().createCriteria(getEntityClass());
    }
}
