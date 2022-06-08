package com.krukowska.service.impl;

import com.krukowska.converter.CSRConverter;
import com.krukowska.converter.StudentConverter;
import com.krukowska.domain.Student;
import com.krukowska.exception.StudentRequestException;
import com.krukowska.model.CreateStudentRequest;
import com.krukowska.model.StudentDTO;
import com.krukowska.repository.StudentRepository;
import com.krukowska.service.IStudentService;
import com.krukowska.validator.PeselValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository ;
    private final StudentConverter studentConverter;
    private final PeselValidator peselValidator;
    private final CSRConverter csrConverter;

    public StudentService(StudentRepository studentRepository, StudentConverter studentConverter, PeselValidator peselValidator, CSRConverter csrConverter) {
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
        this.peselValidator = peselValidator;
        this.csrConverter = csrConverter;
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

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student studentEntity = studentRepository.save(studentConverter.toEntity(studentDTO));
        return studentConverter.toDTO(studentEntity);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public StudentDTO findStudentByPesel(String pesel){
        Student student  = studentRepository.findStudentByPesel(pesel)
                .orElseThrow(() -> new StudentRequestException("No Student under the Pesel : " + pesel, HttpStatus.NOT_FOUND));
        return studentConverter.toDTO(student);
    }

    public CreateStudentRequest autofillByPesel(CreateStudentRequest createStudentRequest){
        Student student = studentRepository.save(csrConverter.toEntity(createStudentRequest));
        student.setGender(peselValidator.getSex(student.getPesel()));
        student.setDob(peselValidator.getBirthDate(student.getPesel()));
        student.setAge(peselValidator.getAge(student.getPesel()));
        studentRepository.autoFillByPesel(student);
        return csrConverter.toDTO(student);
    }
}