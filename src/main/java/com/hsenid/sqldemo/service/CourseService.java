package com.hsenid.sqldemo.service;

import com.hsenid.sqldemo.dto.CourseDTO;
import com.hsenid.sqldemo.entity.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(CourseDTO courseDTO);

    void updateCourse(CourseDTO courseDTO,int id);

    void deleteCourse(String name);

    Course searchCourse(String name);

    List<Course> findAll();

}
