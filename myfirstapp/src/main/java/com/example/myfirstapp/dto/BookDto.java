package com.example.myfirstapp.dto;

import lombok.*;


@Getter
@Setter
@Builder
public class BookDto {

    private String name;
    private String authur;
    private int student_id;

}
