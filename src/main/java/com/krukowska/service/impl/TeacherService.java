package com.krukowska.service.impl;

import com.krukowska.converter.TeacherConverter;
import com.krukowska.domain.Teacher;
import com.krukowska.exception.TeacherRequestException;
import com.krukowska.model.TeacherDTO;
import com.krukowska.repository.TeacherRepository;
import com.krukowska.service.ITeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherConverter teacherConverter;

    public TeacherService(TeacherRepository teacherRepository, TeacherConverter teacherConverter) {
        this.teacherRepository = teacherRepository;
        this.teacherConverter = teacherConverter;
    }

    public List<TeacherDTO> findAll() {
        return teacherConverter.toDTO(teacherRepository.findAll());
    }

    public TeacherDTO getTeacherById(String id){

         Teacher teacher =  teacherRepository.findById(id)
                 .orElseThrow(() -> new TeacherRequestException("No Teacher under the id : " + id, HttpStatus.NOT_FOUND));
        return teacherConverter.toDTO(teacher);

    }

    public TeacherDTO createTeacher(Teacher teacher){
        return teacherConverter.toDTO(teacherRepository.save(teacher));
    }

    public void deleteTeacher(String id){
         teacherRepository.deleteById(id);
    }

    public TeacherDTO findTeacherByPesel(String pesel){
            Teacher teacher =  teacherRepository.findTeacherByPesel(pesel)
                     .orElseThrow(() -> new TeacherRequestException("No teacher under the pesle of: "+ pesel, HttpStatus.NOT_FOUND));
            return teacherConverter.toDTO(teacher);
    }

}
