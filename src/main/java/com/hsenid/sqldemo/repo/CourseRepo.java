package com.hsenid.sqldemo.repo;

import com.hsenid.sqldemo.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends MongoRepository<Course,Integer> {
    boolean findByName(String name);

    void deleteByName(String name);

    Course findCourseByName(String name);

    Course findCourseById(int id);

}
