package com.tw.core.dao;

import com.tw.core.entity.Employee;

import java.util.List;

/**
 * Created by qxue on 8/5/15.
 */
public interface EmployeeDao {
    List<Employee> getEmployees();

    void addEmployee(Employee employee);

    Employee getEmployeeByName(String name);

    Employee getEmployeeById(int id);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);
}
