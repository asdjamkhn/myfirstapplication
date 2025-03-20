package com.example.myfirstapp.repository;

import com.example.myfirstapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookInterface extends JpaRepository<Book,Integer> {
    @Query(value = "Select b.* from Book as b where b.student_id =:id ",nativeQuery = true)
    List<Book> findByStudentId(int id);

}
