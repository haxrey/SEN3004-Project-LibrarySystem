package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookRep;
import com.example.demo.model.Book;

@Service
public class BookService {

    @Autowired
    private BookRep bookRepository;

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }
}