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
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by qxue on 7/15/15.
 */
@RestController
@RequestMapping("/")
public class UserSessionController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLoginPage(HttpServletRequest request, HttpServletResponse response) {

        addCurrentIsLoginCookie(request, response);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(@CookieValue("URI") String uriCookie, @RequestParam String name, @RequestParam String password, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        if (IsPasswordCorrect(name, password)) {

            return logIn(uriCookie, session, response);
        } else {

            session.setAttribute("isLogin", "invalid");

            ModelAndView modelAndView = new ModelAndView("redirect:/");
            addURICooike(request, response);
            return modelAndView;
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        String isLoginSession = (String) session.getAttribute("isLogin");

        if ("valid".equals(isLoginSession)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");
            modelAndView.addObject("users", userService.getUsers());

            return modelAndView;

        } else {

            addURICooike(request, response);
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/creation", method = RequestMethod.GET)
    public ModelAndView getAddUserPage(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        String isLoginSession = (String) session.getAttribute("isLogin");

        if ("valid".equals(isLoginSession)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("addUser");

            return modelAndView;

        } else {

            addURICooike(request, response);
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/creation", method = RequestMethod.POST)
    public ModelAndView addUser(HttpSession session, @RequestParam String name, @RequestParam String sex, @RequestParam String address, @RequestParam int age, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {

        String isLoginSession = (String) session.getAttribute("isLogin");

        if ("valid".equals(isLoginSession)) {
            User user = null;

            try {
                user = new User(name, sex, address, age, MD5Util.getMD5(password));
            } catch (Exception e) {
                e.printStackTrace();
            }

            userService.addUser(user);
            return new ModelAndView("redirect:/users");

        } else {

            addURICooike(request, response);
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(HttpSession session, @PathVariable int id, HttpServletRequest request, HttpServletResponse response) {

        String isLoginSession = (String) session.getAttribute("isLogin");

        if ("valid".equals(isLoginSession)) {

            userService.deleteUser(id);

        } else {

            addURICooike(request, response);
        }
    }

    @RequestMapping(value = "/users/modification/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUserPage(HttpSession session, @PathVariable int id, HttpServletRequest request, HttpServletResponse response) {

        String isLoginSession = (String) session.getAttribute("isLogin");

        if ("valid".equals(isLoginSession)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("updateUser");
            modelAndView.addObject("user", userService.getUserById(id));

            return modelAndView;
        } else {

            addURICooike(request, response);

            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/users/modification/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(HttpSession session, @PathVariable int id, @RequestParam String name, @RequestParam String sex, @RequestParam String address, @RequestParam int age, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {

        String isLoginSession = (String) session.getAttribute("isLogin");

        if ("valid".equals(isLoginSession)) {

            User user = new User(id, name, sex, address, age, changePassword(id, password));
            userService.updateUser(user);

            return new ModelAndView("redirect:/users");

        } else {

            addURICooike(request, response);

            return new ModelAndView("redirect:/");
        }
    }

    private void addCurrentIsLoginCookie(HttpServletRequest request, HttpServletResponse response) {
        if (request.getCookies() == null) {

            addURICooike(request, response);
        }
    }

    private boolean IsPasswordCorrect(String name, String password) {

        List<User> userList = userService.getUserByName(name);
        User userDatabase = userList.get(0);

        String passwordMD5 = null;

        try {
            passwordMD5 = MD5Util.getMD5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userDatabase.getPassword().equals(passwordMD5);
    }

    private void addURICooike(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("URI", String.valueOf(request.getRequestURI()).substring(4));
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private void deleteURICooike(HttpServletResponse response) {
        Cookie cookie = new Cookie("URI", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private ModelAndView logIn(String uriCookie, HttpSession session, HttpServletResponse response) {

        session.setAttribute("isLogin", "valid");

        if ("/".equals(uriCookie)) {

            ModelAndView modelAndView = new ModelAndView("redirect:" + "/users");
            deleteURICooike(response);
            return modelAndView;

        } else {

            ModelAndView modelAndView = new ModelAndView("redirect:" + uriCookie);
            deleteURICooike(response);
            return modelAndView;
        }
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
