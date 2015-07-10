package com.tw.core.dao;

import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserDao {


    public List<User> getUsers(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<User> userList = session.createQuery("from User").list();

        session.close();
        return userList;
    }

    public void addUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

        session.close();
    }

    public void deleteUser(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User user = (User)session.load(User.class,id);
        session.delete(user);
        session.getTransaction().commit();

        session.close();
    }

    public User getUserById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();

        User user = (User)session.get(User.class,id);

        session.close();
        return user;
    }

    public void updateUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();

        session.close();
    }
}

