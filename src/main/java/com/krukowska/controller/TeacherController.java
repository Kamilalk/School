package com.krukowska.controller;

import com.krukowska.domain.Teacher;
import com.krukowska.repository.TeacherRepository;
import com.krukowska.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> getTeacherById(@Pag
    }

    @GetMapping("/employees")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }

    
}




