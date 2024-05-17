package com.example.demo.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AuthorRep;
import com.example.demo.dao.BookRep;
import com.example.demo.model.Author;
import com.example.demo.model.Book;

@Service
public class BookService {
    @Autowired
    private BookRep bookRepository;
    @Autowired
    private AuthorRep authorRepository;

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Book findById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    // @mustafa :)
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}