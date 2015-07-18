package com.tw.core.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by qxue on 7/16/15.
 */
@Entity
@Table(name = "course")
public class Course {

    private int id;
    private String name;
    private Employee employee;
    private String time;

    public Course() {
    }

    public Course(String name,Employee employee,String time){
        this.name = name;
        this.employee = employee;
        this.time = time;
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

    @Column(name ="time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}


