package com.tw.core.dao;

import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
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

        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
//
//    public void deleteUser(int id){
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//
//        session.beginTransaction();
//        User user = (User)session.load(User.class,id);
//        session.delete(user);
//        session.getTransaction().commit();
//    }

    public User getUserById(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        User user;

        try {
            session.beginTransaction();
            user = (User) session.get(User.class, id);
            session.getTransaction().commit();
        }catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

        return user;
    }

//    public void updateUser(User user){
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//
//        session.beginTransaction();
//        session.update(user);
//        session.getTransaction().commit();
//    }

    public User getUserByName(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        User user;

        try {
            session.beginTransaction();
            Query query = session.createQuery("from User where name=:name");
            query.setString("name", name);
            user = (User) query.uniqueResult();
            session.getTransaction().commit();
        }catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
        return user;
    }
}

