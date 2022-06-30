package com.krukowska.controller;

import com.krukowska.model.ClasDTO;
import com.krukowska.model.CreateClasRequest;
import com.krukowska.service.IClasService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clas")
public class ClasController {
    private final IClasService classService;

    public ClasController(IClasService iClassService) {
        this.classService = iClassService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createClas(@RequestBody CreateClasRequest clasRequests){
        classService.createClas(clasRequests);
    }

    @DeleteMapping("/deleteByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClas(@PathVariable String id){
        classService.deleteClas(id);
    }

    @GetMapping("/findByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClasDTO getClasById(@PathVariable String id){
        return classService.findById(id);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ClasDTO> findAllClas() {
        return classService.findAll();
    }

    @DeleteMapping("/deleteTeacherFromClass")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeacherByID(@RequestParam String teacherId, String clasId){
        classService.deleteTeacherFromClass(teacherId, clasId);
    }

   @PostMapping("/addTeacher")
   @ResponseStatus(HttpStatus.CREATED)
    public void addTeacher(@RequestParam String teacherId, String clasId){
        classService.addTeacher(teacherId, clasId);
    }

    @PostMapping("/addTeachers")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTeachers(@RequestBody List<String> teacherIds, String clasId){
        classService.addTeachers(teacherIds, clasId);
    }

}
