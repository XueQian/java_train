package com.tw.core.dao;

import com.tw.core.entity.Employee;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@ActiveProfiles(profiles = "test",inheritProfiles = true)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
@Rollback(true)
public class EmployeeDaoTest {

    @BeforeClass
    public static void setSystemProperty() {
        System.setProperty("spring.profiles.active", "test");
    }

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testGetEmployees() {

        List<Employee> employees = employeeDao.getEmployees();

        Assert.assertEquals(employees.size(), 1);
        Assert.assertEquals(employees.get(0).getName(),"测试");
    }

    @Test
    public void testAddEmployee(){

        Employee employee = new Employee("coach","testAdd","add@qq.com");
        employeeDao.addEmployee(employee);
        List<Employee> employeeList = employeeDao.getEmployees();

        Assert.assertEquals(employeeList.size(),2);
        Assert.assertEquals(employeeList.get(1).getName(),"testAdd");
    }
}
