package com.fpt.university.toandc.service.impl;

import com.fpt.university.toandc.dao.UserDAO;
import com.fpt.university.toandc.model.User;
import com.fpt.university.toandc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ToanQri on 9/14/2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User findById(long userId) {
        return userDAO.findById(userId);
    }

    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public void deleteUser(long userId) {
        userDAO.deleteUser(userId);
    }
}
