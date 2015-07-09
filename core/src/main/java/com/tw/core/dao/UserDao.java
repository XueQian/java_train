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
//    public void updateUser(User user){
//
//        String sql = "update User set name=?,sex=?,address=?,age=?"+" where id=?";
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,user.getName());
//            preparedStatement.setString(2,user.getSex());
//            preparedStatement.setString(3,user.getAddress());
//            preparedStatement.setInt(4, user.getAge());
//            preparedStatement.setInt(5,user.getId());
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public User getUserById(int id) {
//
//        String sql = "select * from User where id=?";
//        User user = new User();
//
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                user.setId(rs.getInt("id"));
//                user.setName(rs.getString("name"));
//                user.setSex(rs.getString("sex"));
//                user.setAddress(rs.getString("address"));
//                user.setAge(rs.getInt("age"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
}

