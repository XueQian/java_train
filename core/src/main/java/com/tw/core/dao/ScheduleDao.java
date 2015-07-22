package com.tw.core.dao;

import com.tw.core.entity.Schedule;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qxue on 7/22/15.
 */
@Repository
public class ScheduleDao {

    public List<Schedule> getSchedules() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Schedule> scheduleList;

        try {
            session.beginTransaction();
            scheduleList = session.createQuery("from Schedule").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

        return scheduleList;
    }

    public void addSchedule(Schedule schedule) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.save(schedule);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

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
}
