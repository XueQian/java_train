package com.tw.core.service;

import com.tw.core.dao.CourseDao;
import com.tw.core.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qxue on 7/17/15.
 */
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> getCourses(){
        return courseDao.getCourses();
    }
}
