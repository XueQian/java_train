package com.tw.core.service;

import com.tw.core.dao.CustomerDao;
import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qxue on 7/19/15.
 */
@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public void addCustomer(Customer customer){
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByName(String name){
        return customerDao.getCustomerByName(name);
    }

    public void deleteCustomer(Employee employee){
        customerDao.deleteCustomer(employee);
    }

    public List<Customer> getCustomers(){
        return customerDao.getCustomers();
    }

    public Customer getCustomerById(int id){
        return customerDao.getCustomerById(id);
    }

    public void updateCustomer(Customer customer){
        customerDao.updateCustomer(customer);
    }

    public void deleteCustomer(int id){
        customerDao.deleteCustomer(id);
    }

    public Customer getCustomerByEmployee(Employee employee){
        return customerDao.getCustomerByEmployee(employee);
    }
}
