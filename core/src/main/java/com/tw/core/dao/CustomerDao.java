package com.tw.core.dao;

import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qxue on 7/19/15.
 */
@Repository
public class CustomerDao {

    public void addCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public Customer getCustomerByName(String name){
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

    public void deleteCustomer(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            Query query = session.createQuery("from Customer where employee=:employee");
            query.setEntity("employee",employee);
            Customer customer = (Customer) query.uniqueResult();
            session.delete(customer);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public List<Customer> getCustomers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        List<Customer> customerList;

        try {
            session.beginTransaction();
            customerList = session.createQuery("from Customer").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

        return customerList;
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
}
