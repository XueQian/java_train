package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by qxue on 7/11/15.
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLoginPage(HttpServletRequest request, HttpServletResponse response) {

        addCurrentIsLoginCookie(request, response);
        response.addCookie(new Cookie("isLogin", "invalid"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(@CookieValue("URI") String uriCookie, @RequestParam String name, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {

        List<User> userList = userService.getUserByName(name);
        User userDatabase = userList.get(0);

        String passwordMD5 = null;

        try {
            passwordMD5 = MD5Util.getMD5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userDatabase.getPassword().equals(passwordMD5)) {

            if ("/".equals(uriCookie)) {

                response.addCookie(new Cookie("isLogin", "valid"));

                ModelAndView modelAndView = new ModelAndView("redirect:" + "/users");
                Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
                cookie.setPath("/");
                response.addCookie(cookie);
                return modelAndView;

            } else {

                response.addCookie(new Cookie("isLogin", "valid"));

                ModelAndView modelAndView = new ModelAndView("redirect:" + uriCookie);
                Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
                cookie.setPath("/");
                response.addCookie(cookie);
                return modelAndView;
            }
        } else {

            response.addCookie(new Cookie("isLogin", "invalid"));

            ModelAndView modelAndView = new ModelAndView("redirect:/");
            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);
            return modelAndView;
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(@CookieValue("isLogin") String isLoginCookie, HttpServletRequest request, HttpServletResponse response) {

        if ("valid".equals(isLoginCookie)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");
            modelAndView.addObject("users", userService.getUsers());

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);
            return modelAndView;

        } else {

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/creation", method = RequestMethod.GET)
    public ModelAndView getAddUserPage(@CookieValue("isLogin") String isLoginCookie, HttpServletRequest request, HttpServletResponse response) {

        if ("valid".equals(isLoginCookie)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("addUser");

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);
            return modelAndView;

        } else {

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/creation", method = RequestMethod.POST)
    public ModelAndView addUser(@CookieValue("isLogin") String isLoginCookie, @RequestParam String name, @RequestParam String sex, @RequestParam String address, @RequestParam int age, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {

        if ("valid".equals(isLoginCookie)) {
            User user = null;

            try {
                user = new User(name, sex, address, age, MD5Util.getMD5(password));
            } catch (Exception e) {
                e.printStackTrace();
            }

            userService.addUser(user);
            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);
            return new ModelAndView("redirect:/users");

        } else {

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@CookieValue("isLogin") String isLoginCookie, @PathVariable int id, HttpServletRequest request, HttpServletResponse response) {

        if ("valid".equals(isLoginCookie)) {

            userService.deleteUser(id);
            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);

        } else {

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    @RequestMapping(value = "/users/modification/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUserPage(@CookieValue("isLogin") String isLoginCookie, @PathVariable int id, HttpServletRequest request, HttpServletResponse response) {

        if ("valid".equals(isLoginCookie)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("updateUser");
            modelAndView.addObject("user", userService.getUserById(id));

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);

            return modelAndView;
        } else {

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);

            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/modification/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@CookieValue("isLogin") String isLoginCookie, @PathVariable int id, @RequestParam String name, @RequestParam String sex, @RequestParam String address, @RequestParam int age, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {

        if ("valid".equals(isLoginCookie)) {
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

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);
            return new ModelAndView("redirect:/users");

        } else {

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);

            return new ModelAndView("redirect:/");
        }
    }

    private void addCurrentIsLoginCookie(HttpServletRequest request, HttpServletResponse response) {
        if (request.getCookies() == null) {

            Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }
}



