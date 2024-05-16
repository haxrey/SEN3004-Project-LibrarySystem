package com.example.demo.services;

import com.example.demo.model.Genre;
import com.example.demo.dao.GenreRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRep genreRepository;

    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    public Genre findById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

}