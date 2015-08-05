package com.tw.core.dao.impl;

import com.tw.core.entity.Employee;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by qxue on 7/16/15.
 */
@Repository
@Transactional
@EnableTransactionManagement
public class EmployeeDaoImpl implements com.tw.core.dao.EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getEmployees() {

        return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }

    @Override
    public void addEmployee(Employee employee) {

        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee getEmployeeByName(String name) {

        Query query = sessionFactory.getCurrentSession().createQuery("from Employee where name=:name");
        query.setString("name", name);
        return (Employee) query.uniqueResult();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee;

        employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {

        sessionFactory.getCurrentSession().update(employee);
    }

    @Override
    public void deleteEmployee(int id) {

        Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
        sessionFactory.getCurrentSession().delete(employee);
    }
}
