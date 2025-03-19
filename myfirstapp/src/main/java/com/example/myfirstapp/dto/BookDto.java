package com.example.myfirstapp.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BookDto {

    private int id;
    private String name;
    private String authur;
}
