package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by qxue on 7/11/15.
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getUsers(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("users",userService.getUsers());
        return modelAndView;
    }
}

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public ModelAndView getAllUsers(){
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.setViewName("user");
//        modelAndView.addObject("users", userService.getAllUsers());
//
//        return modelAndView;
//    }
