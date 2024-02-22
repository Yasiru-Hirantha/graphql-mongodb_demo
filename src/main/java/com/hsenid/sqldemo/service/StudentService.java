package com.hsenid.sqldemo.service;

import com.hsenid.sqldemo.dto.StudentDTO;
import com.hsenid.sqldemo.entity.Student;

import java.util.List;

public interface StudentService {
    void saveNewStudent(StudentDTO studentDTO);

    List<Student> findAll();

    void updateStudent(StudentDTO studentDTO);

    String deleteStudent(int id);

    Student searchById(int id);
}
