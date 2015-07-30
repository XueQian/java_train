package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.entity.Schedule;
import com.tw.core.service.CourseService;
import com.tw.core.service.CustomerService;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

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

    @RequestMapping(value = "/schedules", method = RequestMethod.POST)
    public void addSchedule(@RequestBody Schedule schedule, HttpServletResponse response) {

        if (!isCoachFree(schedule.getEmployee().getId(), schedule.getTime())) {

            response.setStatus(HttpServletResponse.SC_CONFLICT);
        } else {

            Employee employee = employeeService.getEmployeeById(schedule.getEmployee().getId());
            Course course = courseService.getCourseById(schedule.getCourse().getId());

            Schedule newSchedule = new Schedule(schedule.getTime(), employee, course);

            scheduleService.addSchedule(newSchedule);
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @RequestMapping(value = "/schedules/private", method = RequestMethod.POST)
    public void addPrivateCoach(@RequestParam int customerId, @RequestParam int employeeId,
                                @RequestParam String time, HttpServletResponse response) {

        Customer customer = customerService.getCustomerById(customerId);

        if (customer.getEmployee() != null) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("privateCoachIsExist");

            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
        } else if (!isCoachFree(employeeId, time)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("privateCoachIsBusy");

            response.setStatus(HttpServletResponse.SC_CONFLICT);
        } else {

            Employee employee = employeeService.getEmployeeById(employeeId);

            if (courseService.getCourseByName("私教") == null) {
                courseService.addCourse(new Course("私教"));
            }

            customer.setEmployee(employee);

            Schedule schedule = new Schedule(time, employee, courseService.getCourseByName("私教"));

            Set<Schedule> scheduleSet = new HashSet<Schedule>();
            scheduleSet.add(schedule);

            customer.setSchedules(scheduleSet);

            customerService.updateCustomer(customer);
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.DELETE)
    public void deleteSchedule(@PathVariable int id) {

        Employee employee = scheduleService.getScheduleById(id).getEmployee();

        Customer customer = customerService.getCustomerByEmployee(employee);

        if (employee != null && customer != null) {
            customer = new Customer(customer.getId(), customer.getName(), customer.getSex(), customer.getEmail(), customer.getTelephone(), null);
            customerService.updateCustomer(customer);
        }

        scheduleService.deleteSchedule(id);
    }

    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.PUT)
    public void updateSchedule(@RequestBody Schedule schedule, HttpServletResponse response) {

        Employee employee = employeeService.getEmployeeByName(schedule.getEmployee().getName());
        Course course = courseService.getCourseByName(schedule.getCourse().getName());

        Schedule newSchedule = new Schedule(schedule.getId(), schedule.getTime(), employee, course);

        System.out.println(schedule.getTime());

        if (!isCoachFree(employee.getId(), schedule.getTime())) {

            response.setStatus(HttpServletResponse.SC_CONFLICT);

        } else {
            scheduleService.updateSchedule(newSchedule);
            response.setStatus(HttpServletResponse.SC_OK);
        }
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
