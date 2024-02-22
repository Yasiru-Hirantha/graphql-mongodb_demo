package com.hsenid.sqldemo.controller;

import com.hsenid.sqldemo.dto.StudentDTO;
import com.hsenid.sqldemo.entity.Student;
import com.hsenid.sqldemo.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//@RestController
//@RequestMapping("/student")
//@CrossOrigin
@Controller
public class StudentController  {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @MutationMapping(name = "createStudent")
    public String createStudent(@Argument StudentDTO studentDTO) {
        System.out.println(studentDTO);
        studentService.saveNewStudent(studentDTO);
        return "Ok";
    }
    @QueryMapping("searchStudentById")
    public Student searchStudentById(@Argument int id){
        Student student= studentService.searchById(id);
        return student;
    }

    @MutationMapping(name = "updateStudentById")
    public String updateStudentById(@Argument StudentDTO studentDTO) {
        String message = "Student Id: " + studentDTO.getId() + " updated";
        System.out.println(message);
        studentService.updateStudent(studentDTO);
        return message;
    }
    @MutationMapping(name = "deleteStudentById")
    public String deleteStudentById(@Argument int id){
        studentService.deleteStudent(id);
        return "Student with ID " + id + " has been successfully deleted.";
    }

    @QueryMapping(name = "findAllStudent")
    public List<Student> findAllStudent() {
        return studentService.findAll();
    }




}
