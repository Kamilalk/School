package com.krukowska.model;
import com.krukowska.domain.enums.Subject;
import com.krukowska.domain.enums.Year;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String pesel;
    private Subject subject;
    private Year year;

}
