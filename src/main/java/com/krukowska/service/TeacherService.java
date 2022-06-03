package com.krukowska.service;

import com.krukowska.domain.Teacher;
import com.krukowska.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherService implements ITeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        var teachers =(List<Teacher>) teacherRepository.findAll();

        return teachers;
    }
}
