package com.krukowska.converter;

import com.krukowska.domain.Clas;
import com.krukowska.model.ClasDTO;
import org.springframework.stereotype.Component;
@Component
public class ClasConverter {

    public ClasDTO toDTO(Clas clas){
        return ClasDTO.builder()
                .id(clas.getId())
                .subject(clas.getSubject())
                .year(clas.getYear())
                .teacher(clas.getTeacher())
                .students(clas.getStudents())
                .build();
    }

    public Clas toEntity(ClasDTO clasDTO){
        return Clas.builder()
                .subject(clasDTO.getSubject())
                .year(clasDTO.getYear())
                .teacher(clasDTO.getTeacher())
                .students(clasDTO.getStudents())
                .build();
    }
}
