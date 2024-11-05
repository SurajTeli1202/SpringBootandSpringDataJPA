package com.springcore.springbootandspringdatajpa.controller;

import com.springcore.springbootandspringdatajpa.service.StudentService;
import com.springcore.springbootandspringdatajpa.dto.StudentDTO;
import com.springcore.springbootandspringdatajpa.dto.StudentResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudent(studentDTO);
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDTO>> retrieveStudents() {
        var students = studentService.findAllStudents();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(students);
        }
    }

    @GetMapping("/students/id/{student-id}")
    public ResponseEntity<StudentResponseDTO> retrieveStudentById(@PathVariable("student-id") Integer id) {
        var studentResponseDTO = studentService.findStudentByID(id);
        if (studentResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(studentResponseDTO);
        }
    }

    @GetMapping("/students/{student-name}")
    public ResponseEntity<List<StudentResponseDTO>> retrieveStudentByName(@PathVariable("student-name") String name) {
        var studentResponseDTOs = studentService.findStudentByName(name);
        if (studentResponseDTOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(studentResponseDTOs);
        }
    }

    @DeleteMapping("/students/{student-id}")
    public void deleteStudentById(@PathVariable("student-id") Integer id) {
        studentService.deleteStudent(id);
    }
}
