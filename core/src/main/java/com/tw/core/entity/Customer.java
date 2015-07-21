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
    private Employee employee;
    private Set<Course> courses;

    public Customer(String name){
        this.name = name;
    }

    public Customer(){

    }

    public Customer(int id, String name, Employee employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customer_course", joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
