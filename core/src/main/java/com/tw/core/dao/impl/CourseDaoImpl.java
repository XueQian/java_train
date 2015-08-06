package com.tw.core.dao.impl;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Course> getCourses() {
        return sessionFactory.getCurrentSession().createQuery("from Course").list();
    }

    public void addCourse(Course course) {

        sessionFactory.getCurrentSession().save(course);
    }

    public void deleteCourse(int id) {

        Course course = (Course) sessionFactory.getCurrentSession().load(Course.class, id);
        sessionFactory.getCurrentSession().delete(course);
    }

    public Course getCourseByName(String name) {

        Query query = sessionFactory.getCurrentSession().createQuery("from Course where name=:name");
        query.setString("name", name);
        return (Course) query.uniqueResult();
    }

    public void updateCourse(Course course) {

        sessionFactory.getCurrentSession().update(course);
    }

    public Course getCourseById(int id) {

        return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
    }
}
