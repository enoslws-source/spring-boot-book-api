package com.practice.practice_spring.service;

import com.practice.practice_spring.entities.Book;
import com.practice.practice_spring.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookImplement implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookImplement(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(long id, Book book){
        Book existing = bookRepository.findById(id).orElseThrow();
        existing.setGenre(book.getGenre());
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setPrice(book.getPrice());

        return bookRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(long id){
        bookRepository.deleteById(id);
    }

}
