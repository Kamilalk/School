package com.krukowska.service.impl;

import com.krukowska.domain.Teacher;
import com.krukowska.exeption.TeacherException;
import com.krukowska.repository.TeacherRepository;
import com.krukowska.service.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService( TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll() ;
    }

    public Teacher getTeacherById(String id){
         return teacherRepository.findById(id)
                 .orElseThrow(() -> new TeacherException("No Teacher under the id : " + id));
    }

    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(String id){
         teacherRepository.deleteById(id);
    }
}
