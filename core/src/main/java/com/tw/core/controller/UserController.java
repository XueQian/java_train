package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qxue on 7/11/15.
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ModelAndView getUsers() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/users/creation", method = RequestMethod.GET)
    public ModelAndView getCreateUserPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/users/creation", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name, @RequestParam String sex, @RequestParam String address, @RequestParam String age) {

        User user = new User(name, sex, address, Integer.parseInt(age));
        userService.addUser(user);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/users/deletion/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/users/modify/{id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateUser");
        modelAndView.addObject("user", userService.getUserById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/users/modify/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable String id,@RequestParam String name,@RequestParam String sex,@RequestParam String address,@RequestParam String age) {
        User user = new User(Integer.parseInt(id), name, sex, address, Integer.parseInt(age));
        userService.updateUser(user);
        return new ModelAndView("redirect:/users");
    }
}



