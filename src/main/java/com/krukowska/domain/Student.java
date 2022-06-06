package com.krukowska.domain;

import com.krukowska.domain.enums.ClassGroup;
import com.krukowska.domain.enums.Gender;
import com.krukowska.domain.enums.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Students")
public class Student {

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

    @Column(name = "class_group", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClassGroup classGroup;

    @Column(name = "pesel", nullable = false)
    @Enumerated(EnumType.STRING)
    private String pesel;

}
