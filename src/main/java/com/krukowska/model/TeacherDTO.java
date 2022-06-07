package com.krukowska.model;

import com.krukowska.domain.enums.Gender;
import com.krukowska.domain.enums.Subject;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private Subject subject;
    private String pesel;
}
