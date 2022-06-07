package com.krukowska.service;
import com.krukowska.model.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();
    StudentDTO findStudentById(String id);
    StudentDTO createStudent(StudentDTO student);
    void deleteStudent(String id);
    StudentDTO findStudentByPesel(String pesel);
}
