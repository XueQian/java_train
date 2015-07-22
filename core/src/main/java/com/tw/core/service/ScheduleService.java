package com.tw.core.service;

import com.tw.core.dao.ScheduleDao;
import com.tw.core.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qxue on 7/22/15.
 */
@Service
public class ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;

    public List<Schedule> getSchedules(){
        return scheduleDao.getSchedules();
    }
}
