package com.tw.core.service;

import com.tw.core.dao.UserDao;
import com.tw.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Created by qxue on 7/9/15.
*/
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public List<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}


