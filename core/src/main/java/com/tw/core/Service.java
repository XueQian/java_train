package com.tw.core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {

    DbConnection dbConnection = new DbConnection();
    Connection connection = dbConnection.getConnection();

    public List<User> getUsers() {

        List<User> userList = new ArrayList<User>();

        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM User";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("#################################");
            while (rs.next()){

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                int age = rs.getInt("age");

                User user = new User(id,name,sex,address,age);

                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void addUser(User user){

        String sql = "insert into User(name,sex,address,age)"+"values(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSex());
            preparedStatement.setString(3,user.getAddress());
            preparedStatement.setInt(4,user.getAge());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {

        String sql = "delete from User where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user){

        String sql = "update User set name=?,sex=?,address=?,age=?"+" where id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSex());
            preparedStatement.setString(3,user.getAddress());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setInt(5,user.getId());
            System.out.println(preparedStatement+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {

        String sql = "select * from User where id=?";
        User user = new User();

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setAddress(rs.getString("address"));
                user.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

