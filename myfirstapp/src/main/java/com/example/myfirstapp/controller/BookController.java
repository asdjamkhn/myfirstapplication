package com.example.myfirstapp.controller;

import com.example.myfirstapp.apiresponse.ApiResponse;
import com.example.myfirstapp.dto.BookDto;
import com.example.myfirstapp.service.BookService;
import com.example.myfirstapp.student.Book;
import com.example.myfirstapp.student.Student;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping
    public ApiResponse getAllBooks() {

        List<Book> result = bookService.getAllBooks();

        if (result.isEmpty()) {

            return ApiResponse.builder()
                    .message("Books not found")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        } else
            return ApiResponse.builder()
                    .message("Books found")
                    .status(HttpStatus.FOUND.value())
                    .data(result)
                    .build();
    }

    @GetMapping("/{id}")
    public ApiResponse getBookById(@PathVariable int id) {

        Optional<Book> result = bookService.getBookById(id);

        if (result.isEmpty()) {
            return ApiResponse.builder()
                    .message("Book not found")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        } else {
            return ApiResponse.builder()
                    .message("Book found")
                    .status(HttpStatus.FOUND.value())
                    .data(result)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteBookById(@PathVariable int id) {

        boolean result = bookService.deleteBookById(id);

        if (result == false) {
            return ApiResponse.builder()
                    .message("Book not deleted")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        } else {
            return ApiResponse.builder()
                    .message("Book deleted successfully")
                    .status(HttpStatus.FOUND.value())
                    .data(result)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ApiResponse updateBook(@PathVariable int id, @RequestBody BookDto bookDto) {

        boolean result = bookService.updateBook(id, bookDto);

        if (result == true) {

            return ApiResponse.builder()
                    .message("Book updated")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        } else {
            return ApiResponse.builder()
                    .message("Book not updated")
                    .status(HttpStatus.FOUND.value())
                    .data(result)
                    .build();
        }
    }

    @PostMapping
    public ApiResponse addBook(@RequestBody BookDto bookDto) {

        Book result = bookService.addBook(bookDto);

        if (result != null) {
            return ApiResponse.builder()
                    .message("Book added successfully")
                    .status(HttpStatus.OK.value())
                    .data(result)
                    .build();
        } else {
            return ApiResponse.builder()
                    .message("Book not added")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        }

    }
}