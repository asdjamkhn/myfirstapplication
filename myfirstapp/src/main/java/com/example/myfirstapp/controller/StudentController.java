package com.example.myfirstapp.controller;

import com.example.myfirstapp.apiresponse.ApiResponse;
import com.example.myfirstapp.dto.StudentDto;
import com.example.myfirstapp.service.StudentService;
import com.example.myfirstapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public ApiResponse getStudent() {

        List<Student> result = studentService.getStudent();

        if (result.isEmpty()) {
            return ApiResponse.builder()
                    .message("Student information not found")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        } else {
            return ApiResponse.builder()
                    .message("Student information recieved successfully")
                    .status(HttpStatus.OK.value())
                    .data(result)
                    .build();
        }
    }

    @GetMapping("/{id}")//path variable
    public ApiResponse getStudentById(@PathVariable int id) {

        Optional<Student> result = studentService.getStudentById(id);

        if (result.isPresent()) {
            return ApiResponse.builder()
                    .message("Student fetched")
                    .status(HttpStatus.OK.value())
                    .data(result)
                    .build();
        } else {
            return ApiResponse.builder()
                    .message("Student information not found")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteStudentById(@PathVariable int id) {

        boolean result = studentService.deleteStudentById(id);

        if(result == true){
            return ApiResponse.builder()
                    .message("Student deleted successfully")
                    .status(HttpStatus.OK.value())
                    .data(null)
                    .build();
        }else{
            return ApiResponse.builder()
                    .message("Student not found")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        }

    }

    @PutMapping("/{id}")
    public ApiResponse updateStudent(@PathVariable int id, @RequestBody StudentDto studentDto) {

        boolean result = studentService.updateStudent(id, studentDto);

        if(result == true){
            return ApiResponse.builder()
                    .message("Student updated successfully")
                    .status(HttpStatus.OK.value())
                    .data(result)
                    .build();
        }else{
            return ApiResponse.builder()
                    .message("Student not found")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        }
    }

    @PostMapping
    public ApiResponse addStudent(@RequestBody StudentDto studentDto) {

        Student result = studentService.addStudent(studentDto);

        if(result != null ){
            return ApiResponse.builder()
                    .message("Student added successfully")
                    .status(HttpStatus.OK.value())
                    .data(result)
                    .build();
        }else{
            return ApiResponse.builder()
                    .message("Student not added")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        }
    }
}

