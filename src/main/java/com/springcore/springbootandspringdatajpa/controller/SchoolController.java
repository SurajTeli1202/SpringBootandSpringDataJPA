package com.springcore.springbootandspringdatajpa.controller;

import com.springcore.springbootandspringdatajpa.dto.SchoolDTO;
import com.springcore.springbootandspringdatajpa.model.School;
import com.springcore.springbootandspringdatajpa.repository.SchoolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDTO create(@RequestBody SchoolDTO schoolDTO) {
        School school = toSchool(schoolDTO);
        schoolRepository.save(school);
        return schoolDTO;
    }

    @GetMapping("/schools")
    public List<School> getAll() {
        return schoolRepository.findAll();
    }

    private School toSchool(SchoolDTO schoolDTO) {
        School school = new School();
        school.setName(schoolDTO.name());
        return school;
    }
}
