package com.hsenid.sqldemo.entity;

import com.hsenid.sqldemo.dto.StudentDTO;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Course {
    @Id
    private int id;
    private String name;
    private int duration;
    private List<Student> studentList;
}
