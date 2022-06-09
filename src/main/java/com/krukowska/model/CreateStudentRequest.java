package com.krukowska.model;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest  {
    private String firstName;
    private String lastName;
    private String pesel;
    private String subject;
    private String classGroup;

}
