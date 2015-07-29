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

    public List<Employee> getEmployees() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        List<Employee> employeeList;
        session.beginTransaction();
        employeeList = session.createQuery("from Employee").list();
        session.getTransaction().commit();

        return employeeList;
    }

    public void addEmployee(Employee employee) {
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

    public Employee getEmployeeByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Employee employee;

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Employee where name=:name");
            query.setString("name", name);
            employee = (Employee) query.uniqueResult();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
        return employee;
    }

    public Employee getEmployeeById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Employee employee;

        try {
            session.beginTransaction();
            employee = (Employee) session.get(Employee.class, id);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

        return employee;
    }

    public void updateEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteEmployee(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            Employee employee = (Employee) session.load(Employee.class, id);
            session.delete(employee);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
