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

            Course employee = employeeService.getEmployeeByCourse(course.getId());

            System.out.println(employee.getEmployee().getUserName()+"@@@@@@@@@@@@@@");

            courseModels.add(new CourseModel(course.getName(),employee.getEmployee().getUserName(),"1111"));
        }

//        List<CourseModel> courseList = new ArrayList<CourseModel>();
//
//        courseList.add(new CourseModel("瑜伽","薛倩","7.21"));
//        courseList.add(new CourseModel("舞蹈","李燕子","7.12"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courses");
        modelAndView.addObject("courses",courseModels);
        return modelAndView;
    }
}
