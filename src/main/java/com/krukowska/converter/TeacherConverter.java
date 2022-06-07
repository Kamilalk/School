package com.krukowska.converter;

import com.krukowska.domain.Teacher;
import com.krukowska.model.TeacherDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherConverter {

    public TeacherDTO toDTO(Teacher teacher){
        return TeacherDTO.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .age(teacher.getAge())
                .gender(teacher.getGender())
                .subject(teacher.getSubject())
                .pesel(teacher.getPesel())
                .build();

    }

    public Teacher toEntity(TeacherDTO teacherDTO){
        return Teacher.builder()
                .firstName(teacherDTO.getFirstName())
                .lastName(teacherDTO.getLastName())
                .age(teacherDTO.getAge())
                .gender(teacherDTO.getGender())
                .subject(teacherDTO.getSubject())
                .pesel(teacherDTO.getPesel())
                .build();
    }

    public List<TeacherDTO> toDTO(List<Teacher> teacher){
           return teacher.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
