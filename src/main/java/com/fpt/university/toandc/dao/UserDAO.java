package com.fpt.university.toandc.dao;

import com.fpt.university.toandc.model.User;

import java.util.List;

/**
 * Created by ToanQri on 9/16/2016.
 */
public interface UserDAO {
    List<User> getAllUsers();
    User findById(long userId);
    User findByUsername(String username);
    void saveUser(User user);
    void deleteUser(long userId);
}
