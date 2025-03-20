package com.example.myfirstapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String name;
    private String authur;
}
