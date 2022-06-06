package com.krukowska.service.impl;

import com.krukowska.domain.Student;
import com.krukowska.exeption.TeacherException;
import com.krukowska.repository.StudentRepository;
import com.krukowska.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> findAll() {
        return studentRepository.findAll();
    };


    public Student findStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new TeacherException("No Student under the id : " + id));
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }


}