package com.demo.rest.controller;

import com.demo.rest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentController {

    private List<Student> theStudents;

    @PostConstruct
    public void addingStudent(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student(1, "John", "Doe"));
        theStudents.add(new Student(2, "Jane", "Doe"));
        theStudents.add(new Student(3, "Jack", "Doe"));
        theStudents.add(new Student(4, "Jill", "Doe"));
    }


    @GetMapping("/students")
    public List<Student> studentDetails(){

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student singleStudent(@PathVariable int studentId){
        return theStudents.get(studentId);
    }

}
