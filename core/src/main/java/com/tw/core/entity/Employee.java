package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by qxue on 7/16/15.
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "role")
    private String role;

    public Employee(String userName, String role) {
        this.userName = userName;
        this.role = role;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
