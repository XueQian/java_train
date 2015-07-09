package com.tw.core.dao;

import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDao {

    public List<User> getUsers(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<User> userList = session.createQuery("from User").list();

        session.getTransaction().commit();
        sessionFactory.close();

        return userList;
    }

    public void addUser(User user){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void deleteUser(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user = (User)session.load(User.class,id);

        session.delete(user);

        session.getTransaction().commit();

        sessionFactory.close();
    }

    public User getUserById(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user = (User)session.get(User.class,id);

        session.getTransaction().commit();

        sessionFactory.close();

        return user;
    }

    public void updateUser(User user){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.update(user);

        session.getTransaction().commit();

        sessionFactory.close();
    }
}

