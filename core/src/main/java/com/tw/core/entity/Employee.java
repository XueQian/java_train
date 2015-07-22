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
    private String role;
    private String name;
    private String email;
    private Set<Schedule> schedules;
    private Set<Customer> customers;

    public Employee(String role, String name, String email) {
        this.role = role;
        this.name = name;
        this.email = email;
    }

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Employee(int id, String role, String name, String email) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.email = email;
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

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
