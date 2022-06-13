package com.krukowska.domain;

import com.krukowska.domain.enums.Subject;
import com.krukowska.domain.enums.Year;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "class")
public class Class {
    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "subject")
    private Subject subject;

    @Column(name = "classGroup")
    private Year year;

    @ManyToMany(targetEntity = Teacher.class)
    private Set<Teacher> teacher;

    @OneToMany( targetEntity = Student.class)
    private List students;
}
