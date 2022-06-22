package com.krukowska.repository;

import com.krukowska.domain.Clas;
import com.krukowska.domain.enums.Subject;
import com.krukowska.domain.enums.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClasRepository extends JpaRepository<Clas, String> {

    @Modifying
    @Query(value = "DELETE FROM teacher_clas_map WHERE teacher_id = :teacherId AND clas_id = :clasId", nativeQuery = true)
    void deleteTeacherFromClass(@Param("teacherId") String teacherId, @Param("clasId")String clasId);

    @Modifying
    @Query(value = "INSERT INTO teacher_clas_map(teacher_id, clas_id) VALUES (:teacherId, :clasId)", nativeQuery = true)
    void addTeacher(@Param("teacherId") String teacherId, @Param("clasId")String clasId);

    @Query("SELECT c FROM clas c WHERE c.subject = :subject AND c.year = :year")
    Clas findClass(Subject subject, Year year);

}
