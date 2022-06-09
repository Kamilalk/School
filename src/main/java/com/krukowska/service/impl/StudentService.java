package com.krukowska.service.impl;

import com.krukowska.converter.StudentConverter;
import com.krukowska.domain.Student;
import com.krukowska.exception.StudentRequestException;
import com.krukowska.model.CreateStudentRequest;
import com.krukowska.model.StudentDTO;
import com.krukowska.repository.StudentRepository;
import com.krukowska.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository ;
    private final StudentConverter studentConverter;

    public StudentService(StudentRepository studentRepository, StudentConverter studentConverter) {
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
    }

    public List<StudentDTO> findAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(studentConverter::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO findStudentById(String id) {
          Student student = studentRepository.findById(id)
                 .orElseThrow(() -> new StudentRequestException("No Student under the id : " + id, HttpStatus.NOT_FOUND));
          return studentConverter.toDTO(student);
    }

    public StudentDTO createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student(
                createStudentRequest.getFirstName(),
                createStudentRequest.getLastName(),
                createStudentRequest.getPesel(),
                createStudentRequest.getSubject(),
                createStudentRequest.getClassGroup());
        return studentConverter.toDTO(studentRepository.save(student));
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public StudentDTO findStudentByPesel(String pesel){
        Student student  = studentRepository.findStudentByPesel(pesel)
                .orElseThrow(() -> new StudentRequestException("No Student under the Pesel : " + pesel, HttpStatus.NOT_FOUND));
        return studentConverter.toDTO(student);
    }

}