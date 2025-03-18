package com.example.myfirstapp.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StudentDto {

    private String name;
    private int age;
    private String email;
    private LocalDate dob;

}
