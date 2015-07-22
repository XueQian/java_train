package com.tw.core.model;

/**
 * Created by qxue on 7/17/15.
 */
public class ScheduleModel {

    private int id;
    private String name;
    private String employee;
    private String time;

    public ScheduleModel(int id, String name, String employee, String time) {
        this.id = id;
        this.name = name;
        this.employee = employee;
        this.time = time;
    }

    public ScheduleModel(String name, String employee, String time){
        this.name = name;
        this.employee = employee;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
