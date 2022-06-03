package com.krukowska.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.Set;

@Setter
@Getter
@Entity(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "subject")
    private Set<Subject> subject;

    public Teacher(Long id, String firstName, String lastName, Integer age, Gender gender, Set<Subject> subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        return id != null ? id.equals(teacher.id) : teacher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
