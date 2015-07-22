package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Schedule;
import com.tw.core.model.ScheduleModel;
import com.tw.core.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public ModelAndView getSchedulePage() {

        List<ScheduleModel> scheduleModels = new ArrayList<ScheduleModel>();

        List<Schedule> scheduleList = scheduleService.getSchedules();

        for(Schedule schedule:scheduleList){
            scheduleModels.add(new ScheduleModel(schedule.getCourse().getName(),schedule.getEmployee().getName(),schedule.getTime()));
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("schedules");
        modelAndView.addObject("schedules", scheduleModels);
        return modelAndView;
    }

    @RequestMapping(value = "/schedules/creation", method = RequestMethod.GET)
    public ModelAndView getAddCoursePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addSchedule");

        return modelAndView;
    }

}
