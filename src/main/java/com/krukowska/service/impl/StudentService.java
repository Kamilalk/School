package com.krukowska.service.impl;

import com.krukowska.domain.Student;
import com.krukowska.exception.StudentRequestException;
import com.krukowska.repository.StudentRepository;
import com.krukowska.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository ;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> findAll() {
        return studentRepository.findAll();
    };


    public Student findStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentRequestException("No Student under the id : " + id, HttpStatus.NOT_FOUND));
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public Student findStudentByPesel(String pesel){
        return studentRepository.findStudentByPesel(pesel);
    }
}