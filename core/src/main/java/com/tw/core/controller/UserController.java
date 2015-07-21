package com.tw.core.controller;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.UserService;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
/**
 * Created by qxue on 7/15/15.
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String name, @RequestParam String password) {

        if (userService.getUserByName(name) == null) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("userIsNotExist");
            return modelAndView;
        }
        if (IsPasswordCorrect(name, password)) {

            return new ModelAndView("redirect:" + "/courses");
        } else {

            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/creation", method = RequestMethod.GET)
    public ModelAndView getAddUserPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");

        return modelAndView;
    }

    @RequestMapping(value = "/users/creation", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String userName, @RequestParam String password, @RequestParam String employeeName, @RequestParam String email, @RequestParam String role) {

        if (isUserExist(userName)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("addUserExist");

            return modelAndView;
        } else {

            Employee employee = new Employee(role, employeeName, email);

            if (!isEmployeeExist(userName)) {

                employeeService.addEmployee(employee);
            }

            User user = null;
            try {
                user = new User(userName, MD5Util.getMD5(password), employee);
            } catch (Exception e) {
                e.printStackTrace();
            }

            userService.addUser(user);
            return new ModelAndView("redirect:/courses");
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers() {

        List<User> userList = userService.getUsers();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", userList);
        return modelAndView;
    }

    @RequestMapping(value = "/users/modification/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUserPage(@PathVariable int id) {

        User user = userService.getUserById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/users/modification/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable int id, @RequestParam String name, @RequestParam String password) {

        Employee employee = userService.getUserById(id).getEmployee();

        User user = new User(id, name, changePassword(id, password), employee);

        userService.updateUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/users/deletion/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id) {

        userService.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }

    private boolean isEmployeeExist(String name) {

        boolean flag = true;

        if (employeeService.getEmployeeByName(name) == null) {
            flag = false;
        }
        return flag;
    }

    private boolean isUserExist(String name) {

        boolean flag = true;

        if (userService.getUserByName(name) == null) {
            flag = false;
        }

        return flag;
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


    private String changePassword(int id, String password) {

        String passwordMD5 = password;

        User userDatabase = userService.getUserById(id);

        if (!(userDatabase.getPassword().equals(password))) {
            try {
                passwordMD5 = MD5Util.getMD5(password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return passwordMD5;
    }
}
