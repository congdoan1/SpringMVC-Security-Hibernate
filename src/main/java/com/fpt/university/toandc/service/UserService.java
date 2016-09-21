package com.fpt.university.toandc.service;

import com.fpt.university.toandc.model.User;
import com.fpt.university.toandc.support.SortType;

import java.util.List;

/**
 * Created by ToanQri on 9/14/2016.
 */
public interface UserService {
    List<User> getAllUsers();
    User findById(long userId);
    User findByUsername(String username);
    List<User> findByName(String name, SortType sortType);
    void saveUser(User user);
    void deleteUser(long userId);
}
