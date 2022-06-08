package com.krukowska.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String pesel;

}
