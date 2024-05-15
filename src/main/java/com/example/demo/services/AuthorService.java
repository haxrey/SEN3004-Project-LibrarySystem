package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AuthorRep;
import com.example.demo.model.Author;


@Service
public class AuthorService {

    @Autowired
    private AuthorRep authorRepository;

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
}