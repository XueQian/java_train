package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.entity.Schedule;
import com.tw.core.model.ScheduleModel;
import com.tw.core.service.CourseService;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public ModelAndView getSchedulePage() {

        List<ScheduleModel> scheduleModels = new ArrayList<ScheduleModel>();

        List<Schedule> scheduleList = scheduleService.getSchedules();

        for (Schedule schedule : scheduleList) {
            scheduleModels.add(new ScheduleModel(schedule.getCourse().getName(), schedule.getEmployee().getName(), schedule.getTime()));
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("schedules");
        modelAndView.addObject("schedules", scheduleModels);
        return modelAndView;
    }

    @RequestMapping(value = "/schedules/creation", method = RequestMethod.GET)
    public ModelAndView getAddSchedulePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("coachList", employeeService.getEmployees());
        modelAndView.addObject("courseList", courseService.getCourses());
        modelAndView.setViewName("addSchedule");

        return modelAndView;
    }

    @RequestMapping(value = "/schedules/creation", method = RequestMethod.POST)
    public ModelAndView addSchedule(@RequestParam int courseId, @RequestParam int coachId, @RequestParam String time) {

        if (!isCoachFree(coachId, time)) {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("coachIsBusyWhenAddSchedule");
            return modelAndView;
        }

        Employee employee = employeeService.getEmployeeById(courseId);

        Course course = courseService.getCourseById(coachId);

        Schedule schedule = new Schedule(time, employee, course);

        scheduleService.addSchedule(schedule);

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
