package com.tw.core.service;

import com.tw.core.dao.impl.CourseDaoImpl;
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
    private CourseDaoImpl courseDao;

    public List<Course> getCourses() {
        return courseDao.getCourses();
    }

    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    public void deleteCourse(int id) {
        courseDao.deleteCourse(id);
    }

    public Course getCourseById(int id) {
        return courseDao.getCourseById(id);
    }

    public void updateCourse(Course course){
        courseDao.updateCourse(course);
    }

    public Course getCourseByName(String name){
        return courseDao.getCourseByName(name);
    }
}
