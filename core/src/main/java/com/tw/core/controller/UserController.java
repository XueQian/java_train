package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qxue on 7/11/15.
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLoginPage(HttpServletResponse response) {

        response.addCookie(new Cookie("isLogin", "invalid"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(@RequestParam int id, @RequestParam String password, HttpServletResponse response) {

        User userDatabase = userService.getUserById(id);

        String passwordMD5 = null;

        try {
            passwordMD5 = MD5Util.getMD5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userDatabase.getPassword().equals(passwordMD5)) {

            response.addCookie(new Cookie("isLogin", "valid"));
            return new ModelAndView("redirect:/users");
        } else {

            response.addCookie(new Cookie("isLogin", "invalid"));
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(@CookieValue("isLogin") String cookie) {

        ModelAndView modelAndView = new ModelAndView();

        if ("valid".equals(cookie)) {
            modelAndView.setViewName("index");
            modelAndView.addObject("users", userService.getUsers());
            return modelAndView;

        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/creation", method = RequestMethod.GET)
    public ModelAndView getAddUserPage(@CookieValue("isLogin") String cookie) {
        ModelAndView modelAndView = new ModelAndView();

        if ("valid".equals(cookie)) {

            modelAndView.setViewName("addUser");
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/creation", method = RequestMethod.POST)
    public ModelAndView addUser(@CookieValue("isLogin") String cookie, @RequestParam String name, @RequestParam String sex, @RequestParam String address, @RequestParam int age, @RequestParam String password) {

        if ("valid".equals(cookie)) {
            User user = null;

            try {
                user = new User(name, sex, address, age, MD5Util.getMD5(password));
            } catch (Exception e) {
                e.printStackTrace();
            }

            userService.addUser(user);

            return new ModelAndView("redirect:/users");
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/deletion/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id, @CookieValue("isLogin") String cookie) {

        if ("valid".equals(cookie)) {

            userService.deleteUser(id);
            return new ModelAndView("redirect:/users");
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/modification/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUserPage(@PathVariable int id, @CookieValue("isLogin") String cookie) {

        if ("valid".equals(cookie)) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("updateUser");

            modelAndView.addObject("user", userService.getUserById(id));

            return modelAndView;
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/modification/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@CookieValue("isLogin") String cookie, @PathVariable int id, @RequestParam String name, @RequestParam String sex, @RequestParam String address, @RequestParam int age, @RequestParam String password) {

        if ("valid".equals(cookie)) {
            User user;
            String passwordMD5 = password;

            User userDatabase = userService.getUserById(id);

            if (!(userDatabase.getPassword().equals(password))) {
                try {
                    passwordMD5 = MD5Util.getMD5(password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            user = new User(id, name, sex, address, age, passwordMD5);
            userService.updateUser(user);

            return new ModelAndView("redirect:/users");

        } else {
            return new ModelAndView("redirect:/");
        }
    }
}



