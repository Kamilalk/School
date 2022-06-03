package com.krukowska.controller;

import com.krukowska.domain.Teacher;
import com.krukowska.service.TeacherService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/teachers")
public class TeacherController {


    private TeacherService teacherService;

    public TeacherController(@Qualifier("teacherConstructor") TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.findAll();
    }

    @GetMapping("/teachers/{id}")
    public List<Teacher> getTeacherById(@PathVariable long id) {
         return teacherService.getTeacherId(id);
    }

    //@GetMapping("/teachers")
    //public Teacher createTeacher(@RequestBody Teacher teacher){
      //  return teacherService.save(teacher);
    //}

    
}




