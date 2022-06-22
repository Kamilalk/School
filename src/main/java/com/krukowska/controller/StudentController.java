package com.krukowska.controller;

import com.krukowska.domain.enums.Gender;
import com.krukowska.model.StudentRequest;
import com.krukowska.model.StudentDTO;
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
    public List<StudentDTO> findAllStudents(){
        return iStudentService.findAll();
    }
    @GetMapping("/findByID/{id}")
    public StudentDTO getStudentById(@PathVariable String id){
        return iStudentService.findStudentById(id);
    }
    @PostMapping("/create")
    public StudentDTO createStudent(@RequestBody StudentRequest student){
        return iStudentService.createStudent(student);
    }
    @DeleteMapping("/deleteByID/{id}")
    public void deleteStudent(@PathVariable String id){
        iStudentService.deleteStudent(id);
    }
    @GetMapping("/findByPesel/{pesel}")
    public StudentDTO findStudentByPesel(@PathVariable String pesel){
        return iStudentService.findStudentByPesel(pesel);
    }
    @GetMapping("/findByAgeNGender")
    public List<StudentDTO> findByAgeNGender(@RequestParam Gender gender, int age ){
        return iStudentService.findByAgeNGender(gender, age);
    }

}
