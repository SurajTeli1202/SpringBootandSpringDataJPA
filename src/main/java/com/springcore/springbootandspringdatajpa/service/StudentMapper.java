package com.springcore.springbootandspringdatajpa.service;

import com.springcore.springbootandspringdatajpa.dto.StudentDTO;
import com.springcore.springbootandspringdatajpa.dto.StudentResponseDTO;
import com.springcore.springbootandspringdatajpa.model.School;
import com.springcore.springbootandspringdatajpa.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDTO studentDTO) {
        var student = new Student();
        student.setFirstName(studentDTO.firstName());
        student.setLastName(studentDTO.lastName());
        student.setEmail(studentDTO.email());
        student.setAge(studentDTO.age());
        var school = new School();
        school.setId(studentDTO.schoolID());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDTO toStudentResponseDTO(Student student) {
        return new StudentResponseDTO(student.getFirstName(), student.getLastName(), student.getEmail());
    }
}
