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

        customerList = sessionFactory.getCurrentSession().createQuery("from Customer").list();

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

        sessionFactory.getCurrentSession().save(customer);
    }

    public Customer getCustomerByName(String name) {

        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where name=:name");
        query.setString("name", name);
        return (Customer) query.uniqueResult();
    }

    public Customer getCustomerById(int id) {

        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    public void updateCustomer(Customer customer) {

        sessionFactory.getCurrentSession().update(customer);
    }

    public void deleteCustomer(int id) {

        Customer customer = (Customer) sessionFactory.getCurrentSession().load(Customer.class, id);
        sessionFactory.getCurrentSession().delete(customer);
    }

    public Customer getCustomerByEmployee(Employee employee) {

        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where employee=:employee");
        query.setEntity("employee", employee);
        return (Customer) query.uniqueResult();
    }
}
