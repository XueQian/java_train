package com.tw.core.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by qxue on 7/16/15.
 */
@Entity
@Table(name = "employee")
public class Employee {

    private int id;
    private String userName;
    private String role;
    private Set<Course> courses;
    private Set<Customer> customers;

    public Employee(String userName, String role) {
        this.userName = userName;
        this.role = role;
    }

    public Employee() {
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

    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
