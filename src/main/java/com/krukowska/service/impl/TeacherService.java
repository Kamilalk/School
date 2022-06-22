package com.krukowska.service.impl;

import com.krukowska.converter.TeacherConverter;
import com.krukowska.domain.Teacher;
import com.krukowska.domain.enums.Gender;
import com.krukowska.exception.RequestException;
import com.krukowska.model.TeacherDTO;
import com.krukowska.model.TeacherRequest;
import com.krukowska.repository.TeacherRepository;
import com.krukowska.service.ITeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
                 .orElseThrow(() -> new RequestException("No Teacher under the id : " + id, HttpStatus.NOT_FOUND));
        return teacherConverter.toDTO(teacher);
    }

    public TeacherDTO createTeacher(TeacherRequest teacherRequest){
        Teacher teacherEntity = new Teacher(
                teacherRequest.getFirstName(),
                teacherRequest.getLastName(),
                teacherRequest.getSubject(),
                teacherRequest.getPesel());
        return teacherConverter.toDTO(teacherRepository.save(teacherEntity));
    }

    public void deleteTeacher(String id){
         teacherRepository.deleteById(id);
    }

    public TeacherDTO findTeacherByPesel(String pesel){
            Teacher teacher =  teacherRepository.findTeacherByPesel(pesel)
                     .orElseThrow(() -> new RequestException("No teacher under the pesel of: "+ pesel, HttpStatus.NOT_FOUND));
            return teacherConverter.toDTO(teacher);
    }
    @Override
    public List<TeacherDTO> findByAgeNGender(Gender gender, int age){
        List<Teacher> teacher = teacherRepository.findByAgeNGender(gender, age);
        if(teacher.isEmpty()) throw new RequestException("No" + gender + "teachers, that are " + age + "years old", HttpStatus.NOT_FOUND);
        else
            return teacher.stream().map(teacherConverter::toDTO).collect(Collectors.toList());
    }


}
