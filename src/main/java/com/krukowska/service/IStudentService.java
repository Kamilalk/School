package com.krukowska.service;

import com.krukowska.domain.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();
    Student findStudentById(String id);
    Student createStudent(Student student);
    void deleteStudent(String id);

}
