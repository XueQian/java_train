package com.tw.core.dao;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {

    public List<Course> getCourses() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Course> courseList;

        session.beginTransaction();
        courseList = session.createQuery("from Course").list();
        session.getTransaction().commit();

        return courseList;
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

    public Course getCourseByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Course course;

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Course where name=:name");
            query.setString("name", name);
            course = (Course) query.uniqueResult();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
        return course;
    }
}
