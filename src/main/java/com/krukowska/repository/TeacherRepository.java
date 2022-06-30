package com.krukowska.repository;

import com.krukowska.domain.Teacher;
import com.krukowska.domain.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String>{
    @Query("SELECT t FROM teachers t WHERE t.pesel like ?1")
    Optional<Teacher> findTeacherByPesel(String Pesel);

    @Query("SELECT t FROM teachers t WHERE t.gender = :gender AND t.age = :age")
    List<Teacher> findByAgeNGender(@Param("gender") Gender gender, @Param("age") int age);

    @Query("SELECT t FROM teachers t WHERE t.id = :teachersIds")
    Set<Teacher> findAllTeachersByIds(Set<String> teachersIds);
}
