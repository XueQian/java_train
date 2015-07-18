package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.model.CourseModel;
import com.tw.core.service.CourseService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView getCoursePage() {

        List<CourseModel> courseModels = new ArrayList<CourseModel>();

        List<Course> courseList1 = courseService.getCourses();

        for (Course course : courseList1) {

            Course course1 = employeeService.getEmployeeByCourse(course.getId());

            courseModels.add(new CourseModel(course.getId(),course.getName(), course1.getEmployee().getUserName(), course1.getTime()));
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courses");
        modelAndView.addObject("courses", courseModels);
        return modelAndView;
    }

    @RequestMapping(value = "/courses/creation", method = RequestMethod.GET)
    public ModelAndView getAddCoursePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCourse");

        return modelAndView;
    }

    @RequestMapping(value = "/courses/creation", method = RequestMethod.POST)
    public ModelAndView addCourse(@RequestParam String name, @RequestParam String coach, @RequestParam String time) {

        Employee employee = new Employee(coach, "coach");
        Course course = new Course(name, employee, time);

        Set<Course> courseSet = new HashSet<Course>();
        courseSet.add(course);

        employee.setCourses(courseSet);

        courseService.addEmployeeCourse(employee);
        courseService.addCourse(course);

        return new ModelAndView("redirect:/courses");
    }

    @RequestMapping(value = "/courses/deletion/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id) {

        courseService.deleteCourse(id);
        return new ModelAndView("redirect:/courses");
    }
}


