package com.example.myfirstapp.repository;

import com.example.myfirstapp.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInterface
        extends JpaRepository<Student, Integer>{


}
