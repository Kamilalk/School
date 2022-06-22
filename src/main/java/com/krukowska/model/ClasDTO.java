package com.krukowska.model;

import com.krukowska.domain.Student;
import com.krukowska.domain.Teacher;
import com.krukowska.domain.enums.Subject;
import com.krukowska.domain.enums.Year;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClasDTO {
    private String id;
    private Subject subject;
    private Year year;
    private Set<Teacher> teacher;
    private Set<Student> students;
}
