package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.entity.Schedule;
import com.tw.core.model.ScheduleModel;
import com.tw.core.service.CourseService;
import com.tw.core.service.CustomerService;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qxue on 7/22/15.
 */
@RestController
@RequestMapping("/")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CourseService courseService;

    @Autowired
    CustomerService customerService;


    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public List<Schedule> getSchedules() {

        return scheduleService.getSchedules();
    }

//    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
//    public ModelAndView getSchedulePage() {
//
//        List<ScheduleModel> scheduleModels = new ArrayList<ScheduleModel>();
//
//        List<Schedule> scheduleList = scheduleService.getSchedules();
//
//        for (Schedule schedule : scheduleList) {
//            scheduleModels.add(new ScheduleModel(schedule.getId(), schedule.getCourse().getName(), schedule.getEmployee().getName(), schedule.getTime()));
//        }
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.setViewName("schedules");
//
//        modelAndView.addObject("coachList", employeeService.getEmployees());
//        modelAndView.addObject("courseList", courseService.getCourses());
//
//        modelAndView.addObject("customerList", customerService.getCustomers());
//
//        modelAndView.addObject("schedules", scheduleModels);
//        return modelAndView;
//    }

    @RequestMapping(value = "/schedules/creation", method = RequestMethod.POST)
    public String addSchedule(@RequestParam int courseId, @RequestParam int coachId, @RequestParam String time) {

        if (!isCoachFree(coachId, time)) {

            return "the coach is busy";
        }

        Employee employee = employeeService.getEmployeeById(coachId);

        Course course = courseService.getCourseById(courseId);

        Schedule schedule = new Schedule(time, employee, course);

        scheduleService.addSchedule(schedule);

        return "add schedule is ok";
    }

    @RequestMapping(value = "/schedules/private/creation", method = RequestMethod.POST)
    public String addPrivateCoach(@RequestParam int customerId, @RequestParam int coachId, @RequestParam String time) {

        Customer customer = customerService.getCustomerById(customerId);

        if (customer.getEmployee() != null) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("privateCoachIsExist");

            return "the customer has a private coach";
        }

        if (!isCoachFree(coachId, time)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("privateCoachIsBusy");

            return "the coach is busy";
        }

        Employee employee = employeeService.getEmployeeById(coachId);

        if (courseService.getCourseByName("私教") == null) {
            courseService.addCourse(new Course("私教"));
        }

        customer.setEmployee(employee);

        Schedule schedule = new Schedule(time, employee, courseService.getCourseByName("私教"));

        Set<Schedule> scheduleSet = new HashSet<Schedule>();
        scheduleSet.add(schedule);

        customer.setSchedules(scheduleSet);

        customerService.updateCustomer(customer);
        return "add private coach is ok";
    }

    @RequestMapping(value = "/schedules/modification/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateSchedulePage(@PathVariable int id) {

        Schedule schedule = scheduleService.getScheduleById(id);

        ScheduleModel scheduleModel = new ScheduleModel(schedule.getId(), schedule.getCourse().getName(), schedule.getEmployee().getName(), schedule.getTime());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateSchedule");
        modelAndView.addObject("schedule", scheduleModel);
        return modelAndView;
    }

    @RequestMapping(value = "/schedules/modification/{id}", method = RequestMethod.PUT)
    public String updateSchedule(@PathVariable int id, @RequestParam String name, @RequestParam String coach, @RequestParam String time) {

        Employee employee = employeeService.getEmployeeByName(coach);
        Course course = courseService.getCourseByName(name);

        Schedule schedule = new Schedule(id, time, employee, course);

        if (!isCoachFree(employee.getId(), time)) {

            return "the coach is busy";
        }
        scheduleService.updateSchedule(schedule);

        return "update schedule is ok";
    }

    @RequestMapping(value = "/schedules/deletion/{id}", method = RequestMethod.GET)
    public ModelAndView deleteSchedule(@PathVariable int id) {

        Employee employee = scheduleService.getScheduleById(id).getEmployee();

        Customer customer = customerService.getCustomerByEmployee(employee);

        if (employee != null && customer != null) {
            customer = new Customer(customer.getId(), customer.getName(), customer.getSex(), customer.getEmail(), customer.getTelephone(), null);
            customerService.updateCustomer(customer);
        }

        scheduleService.deleteSchedule(id);
        return new ModelAndView("redirect:/schedules");
    }

    private boolean isCoachFree(int employeeId, String time) {

        boolean flag = true;

        List<Schedule> scheduleList = scheduleService.getScheduleByTime(time);

        List<Integer> employeeIdList = new ArrayList<Integer>();

        for (Schedule schedule : scheduleList) {
            employeeIdList.add(scheduleList.indexOf(schedule), schedule.getEmployee().getId());
        }

        if (employeeIdList.contains(employeeId)) {
            flag = false;
        }

        return flag;
    }

}
