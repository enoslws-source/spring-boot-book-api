package com.practice.practice_spring;

import com.practice.practice_spring.entities.Book;
import com.practice.practice_spring.repositories.BookRepository;
import com.practice.practice_spring.service.BookImplement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookImplement bookService;

    @Test
    void getAllBooks_returnsAllBooks() {
        Book book1 = new Book();
        book1.setTitle("Clean Code");
        book1.setAuthor("Robert Martin");
        book1.setGenre("Programming");
        book1.setPrice(29.99);

        Book book2 = new Book();
        book2.setTitle("The Pragmatic Programmer");
        book2.setAuthor("David Thomas");
        book2.setGenre("Programming");
        book2.setPrice(34.99);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> result = bookService.findAll();

        assertEquals(2, result.size());
    }
}

