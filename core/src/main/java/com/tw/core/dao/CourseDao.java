package com.tw.core.dao;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
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

    public List<Course> getCourses(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List<Course> courseList = session.createQuery("from Course").list();
        session.getTransaction().commit();

        return courseList;
    }

    public List<Course> getCourseByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Query query = session.createQuery("from Course where name=:name");
        List courseList = query.setString("name", name).list();
        session.getTransaction().commit();

        return courseList;
    }

    public void addEmployeeCourse(Employee employee){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    public void addCourse(Course course){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        System.out.println(course.getEmployee().getId()+"!!!!!!!!!!!!!!!!!!");

        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
    }
}
