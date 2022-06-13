package com.krukowska.service;
import com.krukowska.domain.enums.Gender;
import com.krukowska.model.TeacherDTO;
import com.krukowska.model.TeacherRequest;

import java.util.List;

public interface ITeacherService {
    List<TeacherDTO> findAll();
    TeacherDTO getTeacherById(String id);
    TeacherDTO createTeacher(TeacherRequest teacher);
    void deleteTeacher(String id);
    TeacherDTO findTeacherByPesel(String Pesel);
    List<TeacherDTO> findByAgeNGender(Gender gender, int age);
}
