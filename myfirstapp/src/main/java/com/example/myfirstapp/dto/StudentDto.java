package com.example.myfirstapp.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
public class StudentDto {

    private String name;
    private int age;
    private String email;
    private LocalDate dob;

}
