package com.tw.core.dao;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.RootEntityResultTransformer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qxue on 7/16/15.
 */
@Repository
public class EmployeeDao {

    public void addEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();

    }

    public List<Employee> getEmployeeByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Query query = session.createQuery("from Employee where user_name=:name");
        List employeeList = query.setString("name", name).list();
        session.getTransaction().commit();

        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, id);
        session.getTransaction().commit();

        return employee;
    }

    public Course getEmployeeByCourse(int courseId){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Query query= session.createQuery("from Employee e join e.courses course where course.id=:id");
        query.setResultTransformer(RootEntityResultTransformer.INSTANCE);
        query.setInteger("id",courseId);
        Course employee = (Course) query.uniqueResult();

        session.getTransaction().commit();
        return employee;
    }
}
