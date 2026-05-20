package com.practice.practice_spring.service;

import com.practice.practice_spring.entities.Book;

import java.util.List;
import java.util.Optional;


public interface BookService {

    public Optional<Book> findById(long id);
    public Book save(Book book);
    public List<Book> findAll();
    public Book update(long id, Book book);
    public void delete(long id);

}
