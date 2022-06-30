package com.krukowska.domain;

import com.krukowska.domain.enums.Year;
import com.krukowska.domain.enums.Gender;
import com.krukowska.domain.enums.Subject;
import com.krukowska.validator.PeselValidator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Students")
public class Student {

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "first_Name", nullable = false)
    private String firstName;

    @Column(name = "last_Name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "subject", nullable = false)
    @Enumerated(EnumType.STRING)
    private Subject subject;

    @Column(name = "class_group", nullable = false)
    @Enumerated(EnumType.STRING)
    private Year year;

    @Column(name = "pesel", nullable = false, unique = true)
    private String pesel;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @ManyToOne
    @JoinColumn(
            name = "clas_id",
            referencedColumnName = "id"
    )
    private Clas clas;

    public Student(String firstName, String lastName, String pesel, Subject subject, Year year, Clas clas) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = PeselValidator.getAge(pesel);
        this.gender = PeselValidator.getSex(pesel);
        this.subject = subject;
        this.year = year;
        this.pesel = pesel;
        this.dob = PeselValidator.getBirthDate(pesel);
        this.clas = clas;
    }

}
