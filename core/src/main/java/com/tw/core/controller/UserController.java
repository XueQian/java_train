package com.tw.core.controller;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.CourseService;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.UserService;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qxue on 7/15/15.
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {

        return userService.getUsers();
    }


    @RequestMapping(value = "/users/creation", method = RequestMethod.POST)
    public String addUser(@RequestParam String name, @RequestParam String password) {

        if (isUserExist(name)) {

            return "the user is exist";
        }

        User user = null;

        try {
            user = new User(name, MD5Util.getMD5(password), null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        userService.addUser(user);
        return "add use is ok";
    }

    @RequestMapping(value = "/users/modification/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUserPage(@PathVariable int id) {

        User user = userService.getUserById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/users/modification/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable int id, @RequestParam String name, @RequestParam String password) {

        Employee employee = userService.getUserById(id).getEmployee();

        User user = new User(id, name, changePassword(id, password), employee);

        userService.updateUser(user);
    }

    @RequestMapping(value = "/users/deletion/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id) {

        userService.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }

    private boolean isUserExist(String name) {

        boolean flag = true;

        if (userService.getUserByName(name) == null) {
            flag = false;
        }

        return flag;
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
