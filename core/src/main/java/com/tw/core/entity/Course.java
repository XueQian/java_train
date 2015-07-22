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
    private String description;
    private Set<Schedule> schedules;
    private Set<Customer> customers;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(int id) {
        this.id = id;
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

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}


