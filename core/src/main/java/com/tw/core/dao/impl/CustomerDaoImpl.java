package com.tw.core.dao.impl;

import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by qxue on 7/19/15.
 */
@Repository
@Transactional
public class CustomerDaoImpl {


    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomers() {

        List<Customer> customerList;

        customerList = sessionFactory.getCurrentSession() .createQuery("from Customer").list();

//        for (Customer customer : customerList) {
//
////            if (customer.getEmployee() != null) {
////                customer.getEmployee().getEmail();
////            }
//            Hibernate.initialize(customer.getEmployee());
//        }

        return customerList;
    }

    public void addCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    public Customer getCustomerByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Customer customer;

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Customer where name=:name");
            query.setString("name", name);
            customer = (Customer) query.uniqueResult();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
        return customer;
    }

    public Customer getCustomerById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Customer customer;

        try {
            session.beginTransaction();
            customer = (Customer) session.get(Customer.class, id);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

        return customer;
    }

    public void updateCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteCustomer(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            Customer customer = (Customer) session.load(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public Customer getCustomerByEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Customer customer;

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Customer where employee=:employee");
            query.setEntity("employee", employee);
            customer = (Customer) query.uniqueResult();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
        return customer;
    }
}
