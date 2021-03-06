package com.krukowska.service;
import com.krukowska.domain.enums.Gender;
import com.krukowska.model.StudentRequest;
import com.krukowska.model.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();
    StudentDTO findStudentById(String id);
    StudentDTO createStudent(StudentRequest student);
    void deleteStudent(String id);
    StudentDTO findStudentByPesel(String pesel);
    List<StudentDTO> findByAgeNGender(Gender gender, int age);

}
