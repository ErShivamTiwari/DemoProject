package com.demo.jpademo.dao;

import com.demo.jpademo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void saveIntoDB(Student student);

    Student getStudentById(int id);

    List<Student> getAllStudents();

    List<Student> getStudentsByName(String name);

    void updateStudent(Student student);

    void updateAllStudents(String stName);

    void deleteStudentById(int id);

    void deleteAllStudents();
}
