package com.tw.core.dao;

import com.tw.core.entity.Customer;
import com.tw.core.util.HibernateUtil;
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
}
