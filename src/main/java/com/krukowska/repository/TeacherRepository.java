package com.krukowska.repository;

import com.krukowska.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String>{

    @Query("SELECT t FROM teachers t WHERE t.pesel like ?1")
    Teacher findTeacherByPesel(String Pesel);
}
