package com.krukowska.domain;

import com.krukowska.domain.enums.Subject;
import com.krukowska.domain.enums.Year;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clas")
public class Clas {

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "subject", nullable = false)
    @Enumerated(EnumType.STRING)
    private Subject subject;
    @Column(name = "year", nullable = false)
    @Enumerated(EnumType.STRING)
    private Year year;
    @ManyToMany
    @JoinTable(
            name="teacher_clas_map",
            joinColumns = @JoinColumn(
                    name = "clas_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "teacher_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Teacher> teacher;

    @OneToMany(mappedBy = "clas")
    private List<Student> students;

    public Clas(Subject subject, Year year, Set<Teacher> teacher) {
        this.subject = subject;
        this.year = year;
        this.teacher = teacher;
    }
}
