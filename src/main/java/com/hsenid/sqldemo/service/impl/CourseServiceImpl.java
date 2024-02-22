package com.hsenid.sqldemo.service.impl;

import com.hsenid.sqldemo.dto.CourseDTO;
import com.hsenid.sqldemo.entity.Course;
import com.hsenid.sqldemo.entity.Student;
import com.hsenid.sqldemo.repo.CourseRepo;
import com.hsenid.sqldemo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }


    @Override
    public void saveCourse(CourseDTO courseDTO) {
        Course course = new Course(
                courseDTO.getId(),
                courseDTO.getName(),
                courseDTO.getDuration(),
                courseDTO.getStudentList()

        );
        courseRepo.save(course);
    }

    @Override
    public void updateCourse(CourseDTO courseDTO,int id) {
//        Course course = courseRepo.findCourseById(courseDTO.getId());
        Course course=courseRepo.findCourseById(id);
        course.setName(courseDTO.getName());
        course.setDuration(courseDTO.getDuration());
        course.setStudentList(courseDTO.getStudentList());
        courseRepo.save(course);

    }

    @Override
    public void deleteCourse(String name) {
        courseRepo.deleteByName(name);
    }

    @Override
    public Course searchCourse(String name) {
//        boolean validity = courseRepo.findByName(name);
//        Course course = null;
//        if (validity) {
//            course = courseRepo.findCourseByName(name);
//            return course;
//        } else {
//            System.out.println("Invalid course name");
//            return course;
//        }
        Course course=courseRepo.findCourseByName(name);

        if (course==null){
            System.out.println("Course "+name+" is not available");
            return course;
        }else return course;


    }

    @Override
    public List<Course> findAll() {
        List<Course> courseList = courseRepo.findAll();
        return courseList;
    }
}
