package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by qxue on 7/7/15.
 */
//@Entity
//@Table(name = "User")
public class User {

//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @Column(name="name")
    private String name;
//    @Column(name="sex")
    private String sex;
//    @Column(name="address")
    private String address;
//    @Column(name="age")
    private int age;

    public User(){

    }

    public User (int id,String name,String sex,String address,int age){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
