package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by qxue on 7/7/15.
 */
@Entity
@Table(name = "user")
public class User {

    private int id;

    private String name;

    private String password;

    private int employeeId;

    public User(String name, String password, int employeeId) {
        this.name = name;
        this.password = password;
        this.employeeId = employeeId;
    }

    public User() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "employee_id")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
