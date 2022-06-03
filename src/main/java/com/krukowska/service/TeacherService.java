package com.krukowska.service;

import com.krukowska.domain.Teacher;
import com.krukowska.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService implements ITeacherService{

    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public List<Teacher> getTeacherId(long id){
        return findAll().stream().filter(teacher -> teacher.getId() == id)
                .collect(Collectors.toList());
    }
}
