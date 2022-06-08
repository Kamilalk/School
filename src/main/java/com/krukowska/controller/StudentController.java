package com.krukowska.controller;

import com.krukowska.model.CreateStudentRequest;
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
    public StudentDTO createStudent(@RequestBody StudentDTO student){
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
    @PostMapping("/autofillByPesel") // or @put mapping if its update
    public CreateStudentRequest autoFillByPesel(@RequestBody CreateStudentRequest createStudentRequest){
        return iStudentService.autofillByPesel(createStudentRequest);
    }

}
