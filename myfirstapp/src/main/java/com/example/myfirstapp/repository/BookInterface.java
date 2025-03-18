package com.example.myfirstapp.repository;

import com.example.myfirstapp.student.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInterface extends JpaRepository<Book,Integer> {
}
