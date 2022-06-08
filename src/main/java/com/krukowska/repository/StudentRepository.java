package com.krukowska.repository;

import com.krukowska.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
        @Query("SELECT s FROM Students s WHERE s.pesel like ?1")
        Optional<Student> findStudentByPesel(String pesel);
        @Query("INSERT INTO Students (first_Name, last_Name, pesel, age, dob, gender) VALUES( first_Name, last_Name, pesel, age, dob, gender)")
        Student autoFillByPesel(Student student);
}




