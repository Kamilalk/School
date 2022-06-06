package com.krukowska.service;

import com.krukowska.domain.Teacher;
import com.krukowska.repository.TeacherRepository;
import com.krukowska.service.imp.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(String id){
         return teacherRepository.findById(id).orElse(null);
    }

    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(String id){
         teacherRepository.deleteById(id);
    }
}
