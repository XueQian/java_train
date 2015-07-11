package com.tw.core.dao;

import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    public List<User> getUsers(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List<User> userList = session.createQuery("from User").list();
        session.getTransaction().commit();

        return userList;
    }

    public void addUser(User user){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void deleteUser(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        User user = (User)session.load(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
    }

    public User getUserById(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        User user = (User)session.get(User.class,id);
        session.getTransaction().commit();

        return user;
    }

    public void updateUser(User user){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }
}

