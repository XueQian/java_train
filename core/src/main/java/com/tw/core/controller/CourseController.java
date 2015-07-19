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

            courseModels.add(new CourseModel(course.getId(), course.getName(), course1.getEmployee().getUserName(), course1.getTime()));
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

        if (isCoachExist(coach)) {

            employee.setId(employeeService.getEmployeeByName(coach).getId());

            if (!isCoachFree(name, time)) {

                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("addCourseCoachIsBusy");
                return modelAndView;
            }
        } else {

            courseService.addEmployeeCourse(employee);
        }

        Course course = new Course(name, employee, time);

        Set<Course> courseSet = new HashSet<Course>();
        courseSet.add(course);
        employee.setCourses(courseSet);

        courseService.addCourse(course);

        return new ModelAndView("redirect:/courses");
    }

    @RequestMapping(value = "/courses/deletion/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id) {

        courseService.deleteCourse(id);
        return new ModelAndView("redirect:/courses");
    }

    @RequestMapping(value = "/courses/modification/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateCoursePage(@PathVariable int id) {

        Course course = courseService.getCourseById(id);
        CourseModel courseModel = new CourseModel(course.getName(), course.getEmployee().getUserName(), course.getTime());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateCourse");
        modelAndView.addObject("course", courseModel);
        return modelAndView;
    }

    @RequestMapping(value = "/courses/modification/{id}", method = RequestMethod.POST)
    public ModelAndView updateCourse(@PathVariable int id, @RequestParam String name, @RequestParam String coach, @RequestParam String time) {

        Employee employee = new Employee(coach, "coach");

        if(isCoachExist(coach)){
            employee.setId(employeeService.getEmployeeByName(coach).getId());

            if(!isCoachFree(name,time)){

                Course course = new Course(id);

                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("updateCourseCoachIsBusy");
                modelAndView.addObject("course",course);
                return modelAndView;
            }
        }else {
            courseService.addEmployeeCourse(employee);
        }

        Course course = new Course(id, name, employee, time);

        Set<Course> courseSet = new HashSet<Course>();
        courseSet.add(course);
        employee.setCourses(courseSet);
        courseService.updateCourse(course);

        return new ModelAndView("redirect:/courses");
    }

    @RequestMapping(value = "/courses/private/creation", method = RequestMethod.GET)
    public ModelAndView getAddPrivateCoachPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPrivateCoach");

        return modelAndView;
    }

    private boolean isCoachExist(String coachName) {

        boolean flag = true;

        if (employeeService.getEmployeeByName(coachName) == null) {
            flag = false;
        }
        return flag;
    }

    private boolean isCoachFree(String name, String time) {
        boolean flag = true;

        List<Course> courseList = courseService.getCourseByName(name);

        List<String> timeList = new ArrayList<String>();

        for (Course course : courseList) {
            timeList.add(courseList.indexOf(course), course.getTime());
        }

        if (timeList.contains(time)) {
            flag = false;
        }
        return flag;
    }
}


