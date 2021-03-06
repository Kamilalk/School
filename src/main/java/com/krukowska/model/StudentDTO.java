package com.krukowska.model;

import com.krukowska.domain.enums.Year;
import com.krukowska.domain.enums.Gender;
import com.krukowska.domain.enums.Subject;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private Subject subject;
    private Year classGroup;
    private String pesel;
}
