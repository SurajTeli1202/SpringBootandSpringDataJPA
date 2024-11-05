package com.springcore.springbootandspringdatajpa.service;

import com.springcore.springbootandspringdatajpa.dto.StudentDTO;
import com.springcore.springbootandspringdatajpa.dto.StudentResponseDTO;
import com.springcore.springbootandspringdatajpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO saveStudent(StudentDTO studentDTO) {
        var student = studentMapper.toStudent(studentDTO);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDTO(savedStudent);
    }

    public List<StudentResponseDTO> findAllStudents() {
        var students = studentRepository.findAll();
        return students.stream().map(studentMapper::toStudentResponseDTO).collect(Collectors.toList());
    }


    public StudentResponseDTO findStudentByID(int id) {
        var student = studentRepository.findById(id).orElse(null);
        if (student != null){
            return studentMapper.toStudentResponseDTO(student);
        }
        return null;
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public List<StudentResponseDTO> findStudentByName(String name) {
        var students = studentRepository.findByFirstName(name);
        return students.stream().map(studentMapper::toStudentResponseDTO).collect(Collectors.toList());
    }
}
