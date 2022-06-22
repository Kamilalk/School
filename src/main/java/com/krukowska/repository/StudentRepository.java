package com.krukowska.repository;

import com.krukowska.domain.Student;
import com.krukowska.domain.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
        @Query("SELECT s FROM Students s WHERE s.pesel like ?1")
        Optional<Student> findStudentByPesel(String pesel);

        @Query("SELECT s FROM Students s WHERE s.gender = :gender AND s.age = :age")
        List<Student> findByAgeNGender(@Param("gender") Gender gender, @Param("age") int age);

}




