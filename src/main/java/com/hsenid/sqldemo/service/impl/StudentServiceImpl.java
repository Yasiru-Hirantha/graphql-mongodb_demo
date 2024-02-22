package com.hsenid.sqldemo.service.impl;

import com.hsenid.sqldemo.dto.StudentDTO;
import com.hsenid.sqldemo.entity.Student;
import com.hsenid.sqldemo.repo.StudentRepo;
import com.hsenid.sqldemo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void saveNewStudent(StudentDTO studentDTO) {
        Student student=new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAverage()
        );
        studentRepo.save(student);

    }
    @Override
    public List<Student> findAll() {
        List<Student> studentList=studentRepo.findAll();
//        List<StudentDTO> studentDTOList=new ArrayList<>();
//        for (Student student : studentList) {
//            StudentDTO studentDTO=new StudentDTO(
//                    student.getId(),
//                    student.getName(),
//                    student.getAverage()
//            );
//            studentDTOList.add(studentDTO);
        return studentList;

    }
    @Override
    public void updateStudent(StudentDTO studentDTO) {

        Student student=studentRepo.findStudentById(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setAverage(studentDTO.getAverage());
        studentRepo.save(student);
    }
    @Override
    public String deleteStudent(int id) {
        if(studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            String message="Student with ID " + id + " has been successfully deleted successfully";
            return message;

        } else {
            String message="Invalid student id";
            System.out.println(message);
            return message;
        }
    }
    @Override
    public Student searchById(int id) {
        Optional<Student> student=null;
        if(studentRepo.existsById(id)) {
            student=studentRepo.findById(id);
            return student.get();
        } else {
            System.out.println("Invalid student id");
            return student.get();
        }
    }
}
