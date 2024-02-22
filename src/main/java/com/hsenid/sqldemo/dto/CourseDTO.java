package com.hsenid.sqldemo.dto;

import com.hsenid.sqldemo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    private int id;
    private String name;
    private int duration;
    private List<Student> studentList;

}
