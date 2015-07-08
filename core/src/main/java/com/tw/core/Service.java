package com.tw.core;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public List<User> getUser() {

        List<User> userList = new ArrayList<User>();
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();

        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM User";
            ResultSet rs = stmt.executeQuery(sql);
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
}