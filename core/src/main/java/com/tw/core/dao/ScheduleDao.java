package com.tw.core.dao;

import com.tw.core.entity.Schedule;

import java.util.List;

/**
 * Created by qxue on 8/5/15.
 */
public interface ScheduleDao {
    List<Schedule> getSchedules();

    void addSchedule(Schedule schedule);

    void deleteSchedule(int id);

    void updateSchedule(Schedule schedule);

    List<Schedule> getScheduleByTime(String time);

    Schedule getScheduleById(int id);
}
