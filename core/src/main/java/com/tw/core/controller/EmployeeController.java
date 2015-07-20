package com.tw.core.controller;

import com.tw.core.entity.Employee;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by qxue on 7/20/15.
 */
@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView getEmployees() {

        List<Employee> employeeList = employeeService.getEmployees();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employees");
        modelAndView.addObject("employees", employeeList);
        return modelAndView;
    }

    @RequestMapping(value = "/employees/modification/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateEmployeePage(@PathVariable int id) {

        Employee employee = employeeService.getEmployeeById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateEmployee");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @RequestMapping(value = "/employees/modification/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable int id, @RequestParam String name, @RequestParam String role,@RequestParam String email) {

        Employee employee = new Employee(id,name,role,email);

        employeeService.updateEmployee(employee);

        return new ModelAndView("redirect:/employees");
    }

}
