package com.tw.core.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by qxue on 7/22/15.
 */
@Entity
@Table(name = "schedule")
public class Schedule {

    private int id;
    private String time;
    private Employee employee;
    private Course course;

    public Schedule() {
    }

    public Schedule(String time, Employee employee, Course course) {
        this.time = time;
        this.employee = employee;
        this.course = course;
    }

    public Schedule(int id, String time, Employee employee, Course course) {
        this.id = id;
        this.time = time;
        this.employee = employee;
        this.course = course;
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

    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
