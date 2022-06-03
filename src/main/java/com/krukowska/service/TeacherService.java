package com.krukowska.service;

import com.krukowska.domain.Teacher;
import com.krukowska.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService implements ITeacherService{

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public List<Teacher> getTeacherId(long id){
        return findAll().stream().filter(teacher -> teacher.getId() == id)
                .collect(Collectors.toList());
    }

    public Teacher createTeacher(Teacher teacher){
        Teacher newTeacher = new Teacher();
        newTeacher.setFirstName(teacher.getFirstName());
        newTeacher.setLastName(teacher.getFirstName());
        newTeacher.setAge(teacher.getAge());
        newTeacher.setGender(teacher.getGender());
        newTeacher.setSubject(teacher.getSubject());

        return teacherRepository.save(newTeacher);
    }
}
