package com.tw.core.dao;

import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDao {

//    DbConnection dbConnection = new DbConnection();
//    Connection connection = dbConnection.getConnection();

//    public List<User> getUsers() {
//
//        List<User> userList = new ArrayList<User>();
//
//        try {
//            Statement stmt = connection.createStatement();
//            String sql = "SELECT * FROM User";
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()){
//
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String sex = rs.getString("sex");
//                String address = rs.getString("address");
//                int age = rs.getInt("age");
//
//                User user = new User(id,name,sex,address,age);
//
//                userList.add(user);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return userList;
//    }
    public List<User> getUsers(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<User> userList = session.createQuery("from User").list();

        session.getTransaction().commit();
        sessionFactory.close();

        return userList;
    }



//    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//    //getting session object from session factory
//    Session session = sessionFactory.openSession();
//    //getting transaction object from session object
//    session.beginTransaction();
//    Query query = session.createQuery("from Student");
//    List<student> students = query.list();
//    for(Student student : students)
//    {
//        System.out.println("Roll Number: "+student.getRollNumber()+", Student Name: "+student.getStudentName()+", Course: "+student.getCourse());
//    }
//    session.getTransaction().commit();
//    sessionFactory.close();


//    public void addUser(User user){
//
//        String sql = "insert into User(name,sex,address,age)"+"values(?,?,?,?)";
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,user.getName());
//            preparedStatement.setString(2,user.getSex());
//            preparedStatement.setString(3,user.getAddress());
//            preparedStatement.setInt(4,user.getAge());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteUser(int id) {
//
//        String sql = "delete from User where id=?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
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

