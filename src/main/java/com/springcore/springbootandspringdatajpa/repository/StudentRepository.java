package com.springcore.springbootandspringdatajpa.repository;

import com.springcore.springbootandspringdatajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFirstName(String firstName);
}
