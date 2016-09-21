package com.fpt.university.toandc.dao.impl;

import com.fpt.university.toandc.dao.BaseDAO;
import com.fpt.university.toandc.dao.UserDAO;
import com.fpt.university.toandc.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    public void saveUser(User user) {
        getSession().merge(user);
    }

    public void deleteUser(long userId) {
    }
}
