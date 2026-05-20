package com.practice.practice_spring.repositories;

import com.practice.practice_spring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
