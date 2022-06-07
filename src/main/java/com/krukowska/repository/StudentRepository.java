package com.krukowska.repository;

import com.krukowska.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
        @Query("SELECT s FROM Students s WHERE s.pesel like ?1")
        Student findStudentByPesel(String pesel);
}




