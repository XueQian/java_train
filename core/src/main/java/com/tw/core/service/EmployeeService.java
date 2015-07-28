package com.tw.core.service;

import com.tw.core.dao.EmployeeDao;
import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qxue on 7/16/15.
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public Employee getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }

    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    public Employee getEmployeeById(int id){
        return employeeDao.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee){
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(int id){
        employeeDao.deleteEmployee(id);
    }
}
