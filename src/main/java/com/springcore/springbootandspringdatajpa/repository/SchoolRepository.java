package com.springcore.springbootandspringdatajpa.repository;

import com.springcore.springbootandspringdatajpa.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
