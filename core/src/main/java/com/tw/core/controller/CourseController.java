package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.model.ScheduleModel;
import com.tw.core.service.CourseService;
import com.tw.core.service.CustomerService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by qxue on 7/17/15.
 */
@RestController
@RequestMapping("/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getCourses() {

        return courseService.getCourses();
    }

    @RequestMapping(value = "/courses/creation", method = RequestMethod.POST)
    public void addCourse(@RequestParam String name, @RequestParam String description) {

        Course course = new Course(name, description);
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/courses/deletion/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }


    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable int id) {

        return courseService.getCourseById(id);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@PathVariable int id, @RequestParam String name, @RequestParam String description) {

        courseService.updateCourse(new Course(id, name, description));
    }
}


