package com.krukowska.service.impl;

import com.krukowska.converter.StudentConverter;
import com.krukowska.domain.Teacher;
import com.krukowska.exception.TeacherRequestException;
import com.krukowska.repository.TeacherRepository;
import com.krukowska.service.ITeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService {

    private final TeacherRepository teacherRepository;


    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll() ;
    }

    public Teacher getTeacherById(String id){
         return teacherRepository.findById(id)
                 .orElseThrow(() -> new TeacherRequestException("No Teacher under the id : " + id, HttpStatus.NOT_FOUND));
    }

    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(String id){
         teacherRepository.deleteById(id);
    }

    public Teacher findTeacherByPesel(String pesel){
             return teacherRepository.findTeacherByPesel(pesel)
                     .orElseThrow(() -> new TeacherRequestException("No teacher under the pesle of: "+ pesel, HttpStatus.NOT_FOUND));
    }

}
