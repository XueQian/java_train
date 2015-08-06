package com.tw.core.dao.impl;

import com.tw.core.dao.ScheduleDao;
import com.tw.core.entity.Schedule;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by qxue on 7/22/15.
 */
@Repository
@Transactional
public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Schedule> getSchedules() {
        List<Schedule> scheduleList;

        scheduleList = sessionFactory.getCurrentSession().createQuery("from Schedule").list();


//        for (Schedule schedule : scheduleList) {
//
////            if(schedule.getCourse() != null){
////                schedule.getCourse().getDescriptio();
////            }
////
////            if(schedule.getEmployee() != null) {
////                schedule.getEmployee().getSchedules();
////            }
//            Hibernate.initialize(schedule.getCourse());
//            Hibernate.initialize(schedule.getEmployee());
//        }

        return scheduleList;
    }

    @Override
    public void addSchedule(Schedule schedule) {

        sessionFactory.getCurrentSession().save(schedule);
    }

    @Override
    public void deleteSchedule(int id) {

        Schedule schedule = (Schedule) sessionFactory.getCurrentSession().load(Schedule.class, id);
        sessionFactory.getCurrentSession().delete(schedule);
    }

    @Override
    public void updateSchedule(Schedule schedule) {

        sessionFactory.getCurrentSession().update(schedule);
    }

    @Override
    public List<Schedule> getScheduleByTime(String time) {

        Query query = sessionFactory.getCurrentSession().createQuery("from Schedule where time=:time");
        return query.setString("time", time).list();
    }

    @Override
    public Schedule getScheduleById(int id) {

        return  (Schedule) sessionFactory.getCurrentSession().get(Schedule.class, id);
    }
}
