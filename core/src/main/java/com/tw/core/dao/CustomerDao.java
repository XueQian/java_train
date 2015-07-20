package com.tw.core.dao;

import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

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
}
