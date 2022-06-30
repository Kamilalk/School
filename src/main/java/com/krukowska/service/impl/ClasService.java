package com.krukowska.service.impl;

import com.krukowska.converter.ClasConverter;
import com.krukowska.domain.Clas;
import com.krukowska.domain.Teacher;
import com.krukowska.exception.RequestException;
import com.krukowska.model.ClasDTO;
import com.krukowska.model.CreateClasRequest;
import com.krukowska.repository.ClasRepository;
import com.krukowska.repository.TeacherRepository;
import com.krukowska.service.IClasService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ClasService implements IClasService {

    private final ClasRepository clasRepository;
    private final ClasConverter clasConverter;
    private final TeacherRepository teacherRepository;

    public ClasService(ClasRepository clasRepository, ClasConverter clasConverter, TeacherRepository teacherRepository) {
        this.clasRepository = clasRepository;
        this.clasConverter = clasConverter;
        this.teacherRepository = teacherRepository;
    }
    public void createClas(CreateClasRequest clasRequest) {
        Set<Teacher> teacherSet = teacherRepository.findAllTeachersByIds(clasRequest.getTeacherIds());
        Clas clas = new Clas(
               clasRequest.getSubject(),
               clasRequest.getYear(),
                teacherSet
        );
        clasRepository.save(clas);
    }
    public void deleteClas(String id){
        clasRepository.deleteById(id);
    }
    public ClasDTO findById(String id){
        Clas clas = clasRepository.findById(id).orElseThrow();
        return clasConverter.toDTO(clas);
    }
    public List<ClasDTO> findAll(){
        List<Clas> clas = clasRepository.findAll();
        return clas.stream()
                .map(clasConverter::toDTO)
                .collect(Collectors.toList());
    }
    @Transactional
    public void deleteTeacherFromClass(String teacherId, String clasId){
        clasRepository.deleteTeacherFromClass(teacherId, clasId);
    }
    @Transactional
    public void addTeacher(String teacherId, String classId){
       clasRepository.addTeacher(teacherId, classId);
   }
   @Transactional
   public void addTeachers(List<String> teacherIds, String clasId){
        Clas clas = clasRepository.findById(clasId)
                .orElseThrow(() -> new RequestException("No class found by the id of: " + clasId, HttpStatus.NOT_FOUND));
        List<Teacher> newTeachers = teacherRepository.findAllById(teacherIds);
        Set<Teacher> teacher = clas.getTeacher();
        teacher.addAll(newTeachers);
        clasRepository.save(clas);
   }
}
