package com.tw.core.dao.impl;

import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getUsers() {

        List<User> userList;

        userList = sessionFactory.getCurrentSession().createQuery("from User").list();
//
//        for (User user : userList) {
////
////            if (user.getEmployee() != null) {
////                user.getEmployee().getEmail();
////            }
//            Hibernate.initialize(user.getEmployee());
//        }

        return userList;
    }

    public void addUser(User user) {

        sessionFactory.getCurrentSession().save(user);
    }

    public void deleteUser(int id) {

        User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    public User getUserById(int id) {

        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    public void updateUser(User user) {

        sessionFactory.getCurrentSession().update(user);
    }

    public User getUserByName(String name) {

        Query query = sessionFactory.getCurrentSession().createQuery("from User where name=:name");
        query.setString("name", name);
        return (User) query.uniqueResult();
    }
}

