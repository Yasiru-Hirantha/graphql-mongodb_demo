package com.hsenid.sqldemo.repo;

import com.hsenid.sqldemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends MongoRepository<Student,Integer> {
    Student findStudentById(int id);
}
