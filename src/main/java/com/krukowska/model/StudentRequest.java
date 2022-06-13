package com.krukowska.model;
import com.krukowska.domain.enums.Subject;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String pesel;
    private String subject;
    private String classGroup;

}
