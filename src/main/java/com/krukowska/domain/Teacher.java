package com.krukowska.domain;

import com.krukowska.domain.enums.Gender;
import com.krukowska.domain.enums.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
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

    @Column(name = "pesel", nullable = false)
    private String pesel;

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
