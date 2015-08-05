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
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(schedule);
        session.getTransaction().commit();
    }

    @Override
    public void deleteSchedule(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Schedule schedule = (Schedule) session.load(Schedule.class, id);
        session.delete(schedule);
        session.getTransaction().commit();
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.update(schedule);
        session.getTransaction().commit();
    }

    @Override
    public List<Schedule> getScheduleByTime(String time) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List scheduleList;

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Schedule where time=:time");
            scheduleList = query.setString("time", time).list();
            session.getTransaction().commit();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

        return scheduleList;
    }

    @Override
    public Schedule getScheduleById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Schedule schedule;

        try {
            session.beginTransaction();
            schedule = (Schedule) session.get(Schedule.class, id);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
        return schedule;
    }
}
