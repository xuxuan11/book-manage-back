package com.example.springboot.controller;

import com.example.springboot.entity.Book;
import com.example.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @CrossOrigin
    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page")Integer page, @PathVariable("size")Integer size){
        Pageable pageable= PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);

    }
    @CrossOrigin
    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result=bookRepository.save(book);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @CrossOrigin
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @CrossOrigin
    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @CrossOrigin
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }

}
