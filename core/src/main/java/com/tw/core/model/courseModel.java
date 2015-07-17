package com.tw.core.model;

/**
 * Created by qxue on 7/17/15.
 */
public class courseModel {

    private String name;
    private String coach;
    private String time;

    public courseModel(String name, String coach, String time) {
        this.name = name;
        this.coach = coach;
        this.time = time;
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
