package com.hsenid.sqldemo.controller;

import com.hsenid.sqldemo.dto.CourseDTO;
import com.hsenid.sqldemo.entity.Course;
import com.hsenid.sqldemo.service.CourseService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;

    }
    @MutationMapping(name = "createCourse")
    public String createCourse(@Argument CourseDTO courseDTO){
        courseService.saveCourse(courseDTO);
        return "Ok";
    }
    @MutationMapping(name = "updateCourseById")
    public String updateCourseById(@Argument CourseDTO courseDTO,@Argument int id){
        String message = "Course Id: " + courseDTO.getId() + " updated successfully";
        System.out.println(message);
        courseService.updateCourse(courseDTO,id);
        return message;

    }
    @MutationMapping(name = "deleteCourseByName")
    public String deleteCourseByName(@Argument String name){
        System.out.println(name);
        String message = "Course " + name + " deleted";
        System.out.println(message);
        courseService.deleteCourse(name);
        return message;
    }
    @QueryMapping(name = "searchCourseByName")
    public Course searchCourseByName(@Argument String name){
        System.out.println(name);
        Course course= courseService.searchCourse(name);
        return course;
    }
    @QueryMapping(name = "findAllCourses")
    public List<Course> findAllCourses(){
        List<Course> courseList= courseService.findAll();
        return courseList;
    }

}
