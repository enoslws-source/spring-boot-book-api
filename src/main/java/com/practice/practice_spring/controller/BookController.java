package com.practice.practice_spring.controller;


import com.practice.practice_spring.entities.Book;
import com.practice.practice_spring.service.BookImplement;
import com.practice.practice_spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")

public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable long id){
        return bookService.findById(id);
    }

    @PostMapping
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable long id, @RequestBody Book book){
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        bookService.delete(id);
    }

}
