package com.tw.core.service;

import com.tw.core.dao.CourseDao;
import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
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

    public void addEmployeeCourse(Employee employee){
        courseDao.addEmployeeCourse(employee);
    }

    public void addCourse(Course course){
        courseDao.addCourse(course);
    }

    public void deleteCourse(int id){
        courseDao.deleteCourse(id);
    }
}
