package com.krukowska.service;

import com.krukowska.domain.Student;
import com.krukowska.repository.StudentRepository;
import com.krukowska.service.imp.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> findAll(){
        return studentRepository.findAll();
    };


    public Student findStudentById(String id){
        return studentRepository.findById(id).orElse(null);
    }


    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }


}
