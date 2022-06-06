package com.krukowska.controller;

import com.krukowska.domain.Student;
import com.krukowska.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping
    public List<Student> findAllStudents(){
        return iStudentService.findAll();
    }

    @GetMapping("/findByID/{id}")
    public Student getStudentById(@PathVariable String id){
        return iStudentService.findStudentById(id);
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return iStudentService.createStudent(student);
    }

    @DeleteMapping("/deleteByID/{id}")
    public void deleteStudent(@PathVariable String id){
        iStudentService.deleteStudent(id);
    }

}
