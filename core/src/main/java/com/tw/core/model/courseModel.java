package com.tw.core.model;

/**
 * Created by qxue on 7/17/15.
 */
public class CourseModel {

    private int id;
    private String name;
    private String coach;
    private String time;

    public CourseModel(String name, String coach, String time) {
        this.name = name;
        this.coach = coach;
        this.time = time;
    }

    public CourseModel(){

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

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
