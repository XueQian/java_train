package com.tw.core.dao;

import com.tw.core.entity.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
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
}
