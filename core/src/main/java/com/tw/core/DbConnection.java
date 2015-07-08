package com.tw.core;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by qxue on 7/7/15.
 */
public class DbConnection {

    public Connection getConnection(){

        Connection connection = null;
//        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";

        try{
//            Class.forName(driver);
            connection = DriverManager.getConnection(url,"root","12345");

        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}

