package com.tw.core.dao;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.RootEntityResultTransformer;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qxue on 7/16/15.
 */
@Repository
public class CourseDao {

    public List<Course> getCourses() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Course> courseList;

        try {
            session.beginTransaction();
            courseList = session.createQuery("from Course").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

        return courseList;
    }

    public List<Course> getCourseByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List courseList;

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Course where name=:name");
            courseList = query.setString("name", name).list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

        return courseList;
    }

    public List<Course> getCourseByTime(String time) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List courseList;

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Course where time=:time");
            courseList = query.setString("time", time).list();
            session.getTransaction().commit();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

        return courseList;
    }

    public void addEmployeeCourse(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public void addCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

    }

    public void deleteCourse(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            Course course = (Course) session.load(Course.class, id);
            session.delete(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public Course getCourseById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Course course;

        try {
            session.beginTransaction();
            course = (Course) session.get(Course.class, id);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
        return course;
    }

    public void updateCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
