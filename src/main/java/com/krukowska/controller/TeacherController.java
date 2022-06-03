package com.krukowska.controller;

import com.krukowska.domain.Teacher;
import com.krukowska.service.ITeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {
    private final ITeacherService iteacherService;

    public TeacherController(ITeacherService iteacherService){
        this.iteacherService = iteacherService;
    }
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return iteacherService.findAll();
    }

    @GetMapping("/teachers/{id}")
    public List<Teacher> getTeacherById(@PathVariable Long id) {
         return iteacherService.getTeacherId(id);
    }

    @PostMapping("/createTeacher")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return iteacherService.createTeacher(teacher);
    }

    
}




