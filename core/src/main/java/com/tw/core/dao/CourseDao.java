package com.tw.core.dao;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Course> getCourses() {
        return sessionFactory.getCurrentSession().createQuery("from Course").list();
    }

    public void addCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
    }

    public void deleteCourse(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Course course = (Course) session.load(Course.class, id);
        session.delete(course);
        session.getTransaction().commit();
    }

    public Course getCourseByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Course course;

        session.beginTransaction();
        Query query = session.createQuery("from Course where name=:name");
        query.setString("name", name);
        course = (Course) query.uniqueResult();
        session.getTransaction().commit();

        return course;
    }

    public void updateCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
    }

    public Course getCourseById(int id) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Course course;

        course = (Course) sessionFactory.getCurrentSession().get(Course.class, id);
//            session.getTransaction().commit();

        return course;
    }
}
