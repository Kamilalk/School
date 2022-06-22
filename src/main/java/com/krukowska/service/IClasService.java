package com.krukowska.service;
import com.krukowska.model.ClasDTO;
import com.krukowska.model.CreateClasRequest;

import java.util.List;

public interface IClasService {

    void createClas(CreateClasRequest clasRequest);
    void deleteClas(String id);
    ClasDTO findById(String id);
    List<ClasDTO> findAll();
    void deleteTeacherFromClass(String teacherId, String clasId);
    void addTeacher(String teacherId, String classId);
    void addTeachers(List<String> teacherIds, String clasId);

}
