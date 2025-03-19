package com.example.myfirstapp.dto;

import com.example.myfirstapp.student.Book;
import com.example.myfirstapp.student.Student;
import lombok.*;


@Getter
@Setter
@Builder
public class BookDto {

    private String name;
    private String authur;
    private int student_id;

    public static Book toModel(BookDto bookDto){
        return Book.builder().name(bookDto.getName())
                .authur(bookDto.getAuthur())
                .build();
    }

}
