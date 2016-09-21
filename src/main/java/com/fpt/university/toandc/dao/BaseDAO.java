package com.fpt.university.toandc.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by ToanQri on 9/20/2016.
 */
public abstract class BaseDAO<PK extends Serializable, T> {

    private final Class<T> clazz;

    public BaseDAO() {
        this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected Session getSession() {
        Session session = getSessionFactory().getCurrentSession();
        if (session == null) {
            session = getSessionFactory().openSession();
        }
        return session;
    }

    public T getByKey(PK key) {
        return (T) getSession().get(clazz, key);
    }

    public void save(T entity) {
        getSession().merge(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    protected Criteria creatEntityCriteria() {
        return getSession().createCriteria(clazz);
    }
}
