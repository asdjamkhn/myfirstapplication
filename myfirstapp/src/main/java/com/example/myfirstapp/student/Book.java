package com.example.myfirstapp.student;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    private String name;
    private String authur;
}
