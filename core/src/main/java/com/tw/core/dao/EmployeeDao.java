package com.tw.core.dao;

import com.tw.core.entity.Employee;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by qxue on 7/16/15.
 */
@Repository
public class EmployeeDao {

    public void addEmployee(Employee employee){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

}
