package com.krukowska.service;
import com.krukowska.domain.Teacher;
import java.util.List;

public interface ITeacherService {

    List<Teacher> findAll();
    Teacher getTeacherById(String id);
    Teacher createTeacher(Teacher teacher);
    void deleteTeacher(String id);
    Teacher findTeacherByPesel(String Pesel);
}
