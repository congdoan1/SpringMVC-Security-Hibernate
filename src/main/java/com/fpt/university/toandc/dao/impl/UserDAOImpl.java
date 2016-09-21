package com.fpt.university.toandc.dao.impl;

import com.fpt.university.toandc.dao.BaseDAO;
import com.fpt.university.toandc.dao.UserDAO;
import com.fpt.university.toandc.model.User;
import com.fpt.university.toandc.support.SortType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ToanQri on 9/16/2016.
 */
@Repository
public class UserDAOImpl extends BaseDAO<Long, User> implements UserDAO {

    public List<User> getAllUsers() {
        return getSession().createCriteria(User.class).list();
    }

    public User findById(long userId) {
        return getByKey(userId);
    }

    public User findByUsername(String username) {
        Criteria criteria = creatEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

    public List<User> findByName(String name, SortType sortType) {
        System.out.println("name = " + name);
        Criteria criteria = creatEntityCriteria();
        if (sortType == SortType.ASC) {
            criteria.addOrder(Order.asc("name"));
        } else {
            criteria.addOrder(Order.desc("name"));
        }
        criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
        return criteria.list();
    }
    public void saveUser(User user) {
        getSession().merge(user);
    }

    public void deleteUser(long userId) {
        User user = getByKey(userId);
        if (user != null) {
            getSession().delete(user);
        }
    }
}
