package com.krukowska.service;


import com.krukowska.domain.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> findAll();

    List<Teacher> getTeacherId(long id);

    public Teacher createTeacher(Teacher teacher);

}
