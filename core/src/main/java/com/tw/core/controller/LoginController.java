package com.tw.core.controller;

import com.tw.core.entity.User;
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
}
