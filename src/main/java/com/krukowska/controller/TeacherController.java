package com.krukowska.controller;

import com.krukowska.model.TeacherDTO;
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
    public List<TeacherDTO> getAllTeachers() {
        return iteacherService.findAll();
    }

    @GetMapping("/getByID/{id}")
    public TeacherDTO getTeacherById(@PathVariable String id) {
        return iteacherService.getTeacherById(id);
    }

    @PostMapping("/create")
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacher){
        return iteacherService.createTeacher(teacher);
    }

    @DeleteMapping ("deleteByID/{id}")
    public void deleteTeacher(@PathVariable String id){
         iteacherService.deleteTeacher(id);
    }

    @GetMapping("/findByPesel/{pesel}")
    public TeacherDTO findTeacherByPesel(@PathVariable String pesel){
        return iteacherService.findTeacherByPesel(pesel);
    }
}




