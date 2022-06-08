package com.krukowska.converter;

import com.krukowska.domain.Student;
import com.krukowska.model.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public StudentDTO toDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .gender(student.getGender())
                .subject(student.getSubject())
                .classGroup(student.getClassGroup())
                .pesel(student.getPesel())
                .build();
    }

    public Student toEntity(StudentDTO studentDTO){
        return Student.builder()
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .age(studentDTO.getAge())
                .gender(studentDTO.getGender())
                .subject(studentDTO.getSubject())
                .classGroup(studentDTO.getClassGroup())
                .pesel(studentDTO.getPesel())
                .build();
    }
}
