package com.krukowska.converter;

import com.krukowska.domain.Student;
import com.krukowska.model.CreateStudentRequest;
import org.springframework.stereotype.Component;

@Component
public class CSRConverter {
    public CreateStudentRequest toDTO(Student student){
        return CreateStudentRequest.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .pesel(student.getPesel())
                .build();
    }

    public Student toEntity(CreateStudentRequest createStudentRequest){
        return Student.builder()
                .firstName(createStudentRequest.getFirstName())
                .lastName(createStudentRequest.getLastName())
                .pesel(createStudentRequest.getPesel())
                .build();
    }
}
