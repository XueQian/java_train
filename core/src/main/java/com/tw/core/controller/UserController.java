package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView getCreateUserPage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name,@RequestParam String sex,@RequestParam String address,@RequestParam String age){

        User user = new User(name,sex,address,Integer.parseInt(age));
        userService.addUser(user);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "deleteUser",method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam int id){
        userService.deleteUser(id);
        return new ModelAndView("redirect:/");
    }
}



