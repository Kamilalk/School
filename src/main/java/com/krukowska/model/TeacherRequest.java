package com.krukowska.model;

import com.krukowska.domain.enums.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequest {
    private String firstName;
    private String lastName;
    private Subject subject;
    private String pesel;
}
