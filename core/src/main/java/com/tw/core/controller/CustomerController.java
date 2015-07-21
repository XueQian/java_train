package com.tw.core.controller;

import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by qxue on 7/21/15.
 */
@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ModelAndView getCustomers() {

        List<Customer> customerList = customerService.getCustomers();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customers");
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }

    @RequestMapping(value = "/customers/modification/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateCustomerPage(@PathVariable int id) {

        Customer customer = customerService.getCustomerById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateCustomer");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @RequestMapping(value = "/customers/modification/{id}", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@PathVariable int id, @RequestParam String name,@RequestParam String sex,@RequestParam String email,@RequestParam String telephone) {

        Employee employee = customerService.getCustomerById(id).getEmployee();

        Customer customer = new Customer(id, name,sex,email,telephone, employee);

        customerService.updateCustomer(customer);
        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/customers/deletion/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id) {

        customerService.deleteCustomer(id);

        return new ModelAndView("redirect:/customers");
    }
}
