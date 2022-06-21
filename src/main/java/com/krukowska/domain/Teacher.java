package com.krukowska.domain;

import com.krukowska.domain.enums.Gender;
import com.krukowska.domain.enums.Subject;
import com.krukowska.validator.PeselValidator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "teachers")
public class Teacher {
    @Id
    @Column(name = "id",updatable = false, nullable = false,  unique = true)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "first_Name", nullable = false)
    private String firstName;

    @Column(name = "last_Name", nullable = false)
    private String lastName;

    @Column(name = "age",nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "subject", nullable = false)
    @Enumerated(EnumType.STRING)
    private Subject subject;

    @Column(name = "pesel", nullable = false, unique = true)
    private String pesel;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    public Teacher(String firstName, String lastName, Subject subject, String pesel){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = PeselValidator.getAge(pesel);
        this.gender = PeselValidator.getSex(pesel);
        this.subject = subject;
        this.pesel = pesel;
        this.dob = PeselValidator.getBirthDate(pesel);
    }

}
