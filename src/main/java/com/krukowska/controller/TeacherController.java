package com.krukowska.controller;

import com.krukowska.domain.Teacher;
import com.krukowska.service.ITeacherService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {
    private final ITeacherService iteacherService;

    public TeacherController(ITeacherService iteacherService){
        this.iteacherService = iteacherService;
    }
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return iteacherService.findAll();
    }

    @GetMapping("/getByID/{id}")
    public Teacher getTeacherById(@PathVariable String id) {
        return iteacherService.getTeacherById(id);
    }

    @PostMapping("/create")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return iteacherService.createTeacher(teacher);
    }

    @DeleteMapping ("deleteByID/{id}")
    public void deleteTeacher(@PathVariable String id){
         iteacherService.deleteTeacher(id);
    }

    @GetMapping("/findByPesel/{pesel}")
    public Teacher findTeacherByPesel(@PathVariable String pesel){
        return iteacherService.findTeacherByPesel(pesel);
    }
}




