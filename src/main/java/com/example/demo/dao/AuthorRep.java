package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Author;

public interface AuthorRep extends JpaRepository<Author, Long> {
    Author findByName(String name);
}
