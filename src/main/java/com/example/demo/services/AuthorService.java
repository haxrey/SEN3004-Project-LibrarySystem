package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AuthorRep;
import com.example.demo.model.Author;

@Service
public class AuthorService {

    @Autowired
    private AuthorRep authorRepository;

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

}