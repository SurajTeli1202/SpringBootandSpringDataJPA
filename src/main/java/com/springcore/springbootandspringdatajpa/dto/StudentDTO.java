package com.springcore.springbootandspringdatajpa.dto;

public record StudentDTO(
        String firstName,
        String lastName,
        String email,
        Integer age,
        Integer schoolID
) {
}
