package com.tw.core.controller;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.UserService;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qxue on 7/26/15.
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@RequestParam String name, @RequestParam String password) {

        if (userService.getUserByName(name) == null) {

            return "the user is not exist";

        } else if (IsPasswordCorrect(name, password)) {

            return "login is ok";
        } else {

            return "the password is incorrect";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public ModelAndView getRegisterPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam String userName, @RequestParam String password, @RequestParam String employeeName, @RequestParam String email, @RequestParam String role) {

        if (isUserExist(userName)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("addUserExist");

            return modelAndView;
        } else {

            Employee employee = new Employee(role, employeeName, email);

            if (!isEmployeeExist(employeeName)) {

                employeeService.addEmployee(employee);
            }

            User user = null;

            employee = employeeService.getEmployeeByName(employeeName);
            try {
                user = new User(userName, MD5Util.getMD5(password), employee);
            } catch (Exception e) {
                e.printStackTrace();
            }

            userService.addUser(user);
            return new ModelAndView("redirect:/login");
        }
    }

    private boolean IsPasswordCorrect(String name, String password) {

        User userDatabase = userService.getUserByName(name);

        String passwordMD5 = null;

        try {
            passwordMD5 = MD5Util.getMD5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userDatabase.getPassword().equals(passwordMD5);
    }

    private boolean isUserExist(String name) {

        boolean flag = true;

        if (userService.getUserByName(name) == null) {
            flag = false;
        }

        return flag;
    }

    private boolean isEmployeeExist(String name) {

        boolean flag = true;

        if (employeeService.getEmployeeByName(name) == null) {
            flag = false;
        }

        return flag;
    }
}
