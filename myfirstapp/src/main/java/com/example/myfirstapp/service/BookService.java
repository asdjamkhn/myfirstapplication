package com.example.myfirstapp.service;

import com.example.myfirstapp.repository.BookInterface;
import com.example.myfirstapp.student.Book;
import com.example.myfirstapp.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookInterface bookInterface;


    public List<Book> getAllBooks() {

        return bookInterface.findAll();

    }

    public Optional<Book> getBookById(int id) {

        return bookInterface.findById(id);
    }

    public boolean deleteBookById(int id) {

        Optional<Book> book = bookInterface.findById(id);

        if (book.isPresent()) {
            bookInterface.deleteById(id);
        }
        return true;
    }

    public boolean updateBook(int id, Book newbook) {

        Optional<Book> book1 = bookInterface.findById(id);

        if (book1.isPresent()) {

            Book oldBook = bookInterface.findById(id).get();
            oldBook.setId(newbook.getId());
            oldBook.setName(newbook.getName());
            oldBook.setAuthur(newbook.getAuthur());
            bookInterface.save(oldBook);

            return true;
        } else {

            return false;
        }

    }

}
