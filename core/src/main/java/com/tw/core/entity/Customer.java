package com.tw.core.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by qxue on 7/16/15.
 */
@Entity
@Table(name = "customer")
public class Customer {

    private int id;
    private String name;
    private String sex;
    private String email;
    private String telephone;
    private Employee employee;
    private Set<Schedule> schedules;

    public Customer(String name, String sex, String email, String telephone) {
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.telephone = telephone;
    }

    public Customer(int id, String name, String sex, String email, String telephone, Employee employee) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.telephone = telephone;
        this.employee = employee;
    }

    public Customer(String name, String sex, String email, String telephone, Employee employee) {
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.telephone = telephone;
        this.employee = employee;
    }

    public Customer() {

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

    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "customer_schedule", joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "schedule_id")})
    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }
}
