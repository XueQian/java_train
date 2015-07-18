package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.model.CourseModel;
import com.tw.core.service.CourseService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by qxue on 7/17/15.
 */
@RestController
@RequestMapping("/")
public class CourseController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CourseService courseService;

    @RequestMapping(value="/courses",method = RequestMethod.GET)
    public ModelAndView getCoursePage() {

        List<CourseModel> courseModels = new ArrayList<CourseModel>();

        List<Course> courseList1 = courseService.getCourses();

        for(Course course:courseList1){

            Course course1 = employeeService.getEmployeeByCourse(course.getId());

            courseModels.add(new CourseModel(course.getName(),course1.getEmployee().getUserName(),course1.getTime()));
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courses");
        modelAndView.addObject("courses",courseModels);
        return modelAndView;
    }

    @RequestMapping(value = "/courses/creation", method = RequestMethod.GET)
    public ModelAndView getAddCoursePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCourse");

        return modelAndView;
    }
//
//    @RequestMapping(value = "/courses/creation", method = RequestMethod.POST)
//    public ModelAndView addUser(@RequestParam String name, @RequestParam String password, @RequestParam String role) {
//
//        Employee employee = new Employee(name, role);
//
//        employeeService.addEmployee(employee);
//
//        List<Employee> employeeList = employeeService.getEmployeeByName(name);
//
//        Employee employeeDatabase = employeeList.get(0);
//
//        User user = null;
//        try {
//            user = new User(name, MD5Util.getMD5(password), employeeDatabase.getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        userService.addUser(user);
//        return new ModelAndView("redirect:/");
//    }
}
