package com.krukowska.service;
import com.krukowska.domain.Teacher;
import com.krukowska.model.TeacherDTO;

import java.util.List;

public interface ITeacherService {
    List<TeacherDTO> findAll();
    TeacherDTO getTeacherById(String id);
    TeacherDTO createTeacher(TeacherDTO teacher);
    void deleteTeacher(String id);
    TeacherDTO findTeacherByPesel(String Pesel);
}
