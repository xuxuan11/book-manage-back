package com.example.springboot.repository;

import com.example.springboot.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void FindAll(){
        System.out.println(bookRepository.findAll());
    }

    @Test
    void FindById(){
       Book book= bookRepository.findById(1).get();
        System.out.println(book);
    }
}