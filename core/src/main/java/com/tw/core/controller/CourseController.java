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
    private EmployeeService employeeService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView getCoursePage() {

        List<Course> courseList = courseService.getCourses();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courses");
        modelAndView.addObject("courses", courseList);
        return modelAndView;
    }

//    @RequestMapping(value = "/courses/creation", method = RequestMethod.GET)
//    public ModelAndView getAddCoursePage() {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("addCourse");
//
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/courses/creation", method = RequestMethod.POST)
//    public ModelAndView addCourse(@RequestParam String name, @RequestParam String coach, @RequestParam String time) {
//
//        Employee employee = new Employee(coach, "coach");
//
//        if (isCoachExist(coach)) {
//
//            employee.setId(employeeService.getEmployeeByName(coach).getId());
//
//            if (!isCoachFree(coach, time)) {
//
//                ModelAndView modelAndView = new ModelAndView();
//                modelAndView.setViewName("addCourseCoachIsBusy");
//                return modelAndView;
//            }
//        } else {
//
//            courseService.addEmployeeCourse(employee);
//        }
//
//        Course course = new Course(name, employee, time);
//
//        Set<Course> courseSet = new HashSet<Course>();
//        courseSet.add(course);
//        employee.setCourses(courseSet);
//
//        courseService.addCourse(course);
//
//        return new ModelAndView("redirect:/courses");
//    }
//
//    @RequestMapping(value = "/courses/deletion/{id}", method = RequestMethod.GET)
//    public ModelAndView deleteCourse(@PathVariable int id) {
//
//        Employee employee = courseService.getCourseById(id).getEmployee();
//
//        if (employee != null && customerService.getCustomerByEmployee(employee) != null) {
//
//            customerService.deleteCustomer(employee);
//        }
//
//        courseService.deleteCourse(id);
//        return new ModelAndView("redirect:/courses");
//    }
//
//    @RequestMapping(value = "/courses/modification/{id}", method = RequestMethod.GET)
//    public ModelAndView getUpdateCoursePage(@PathVariable int id) {
//
//        Course course = courseService.getCourseById(id);
//        ScheduleModel courseModel = new ScheduleModel(course.getName(), course.getEmployee().getName(), course.getTime());
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("updateCourse");
//        modelAndView.addObject("course", courseModel);
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/courses/modification/{id}", method = RequestMethod.POST)
//    public ModelAndView updateCourse(@PathVariable int id, @RequestParam String name, @RequestParam String coach, @RequestParam String time) {
//
//        Employee employee = new Employee(coach, "coach");
//
//        if (isCoachExist(coach)) {
//            employee.setId(employeeService.getEmployeeByName(coach).getId());
//
//            if (!isCoachFree(coach, time)) {
//
//                Course course = new Course(id);
//
//                ModelAndView modelAndView = new ModelAndView();
//                modelAndView.setViewName("updateCourseCoachIsBusy");
//                modelAndView.addObject("course", course);
//                return modelAndView;
//            }
//        } else {
//            courseService.addEmployeeCourse(employee);
//        }
//
//        Course course = new Course(id, name, employee, time);
//
//        Set<Course> courseSet = new HashSet<Course>();
//        courseSet.add(course);
//        employee.setCourses(courseSet);
//        courseService.updateCourse(course);
//
//        return new ModelAndView("redirect:/courses");
//    }
//
//    @RequestMapping(value = "/courses/private/creation", method = RequestMethod.GET)
//    public ModelAndView getAddPrivateCoachPage() {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("addPrivateCoach");
//
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/courses/private/creation", method = RequestMethod.POST)
//    public ModelAndView addPrivateCoach(@RequestParam String customer,@RequestParam String sex,@RequestParam String email,@RequestParam String telephone, @RequestParam String course, @RequestParam String coach, @RequestParam String time) {
//
//        if (isCustomerExist(customer)) {
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("customerExist");
//
//            return modelAndView;
//        }
//
//        Customer customerObject = new Customer(customer,sex,email,telephone);
//
//        Employee employee = new Employee(coach, "coach");
//
//        if (isCoachExist(coach)) {
//            employee.setId(employeeService.getEmployeeByName(coach).getId());
//
//            if (!isCoachFree(coach, time)) {
//
//                ModelAndView modelAndView = new ModelAndView();
//                modelAndView.setViewName("privateCoachIsBusy");
//                return modelAndView;
//            }
//
//        } else {
//            courseService.addEmployeeCourse(employee);
//        }
//
//        Course courseObject = new Course(course, employee, time);
//
//        Set<Customer> customerSet = new HashSet<Customer>();
//        customerSet.add(customerObject);
//
//        courseObject.setCustomers(customerSet);
//
//        courseService.addCourse(courseObject);
//
//        Set<Course> courseSet = new HashSet<Course>();
//        courseSet.add(courseObject);
//
//        customerObject.setCourses(courseSet);
//        customerObject.setEmployee(employee);
//
//        customerService.addCustomer(customerObject);
//        return new ModelAndView("redirect:/courses");
//    }
//
//    private boolean isCoachExist(String coachName) {
//
//        boolean flag = true;
//
//        if (employeeService.getEmployeeByName(coachName) == null) {
//            flag = false;
//        }
//        return flag;
//    }
//
//    private boolean isCustomerExist(String name) {
//
//        boolean flag = true;
//
//        if (customerService.getCustomerByName(name) == null) {
//            flag = false;
//        }
//
//        return flag;
//    }
//
//    private boolean isCoachFree(String coachName, String time) {
//
//        boolean flag = true;
//
//        List<Course> courseList = courseService.getCourseByTime(time);
//
//        List<String> employeeNameList = new ArrayList<String>();
//
//        for (Course course : courseList) {
//            employeeNameList.add(courseList.indexOf(course), course.getEmployee().getName());
//        }
//
//        if (employeeNameList.contains(coachName)) {
//            flag = false;
//        }
//
//        return flag;
//    }
}


