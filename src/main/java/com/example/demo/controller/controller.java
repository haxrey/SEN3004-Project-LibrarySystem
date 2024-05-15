package com.example.demo.controller;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Genre;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import com.example.demo.services.GenreService;

@Controller
public class controller { 
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;

    @GetMapping("/form.html")
    public ModelAndView displayForm() {
        ModelAndView mv = new ModelAndView("form");
        mv.addObject("book", new Book());
        mv.addObject("genres", genreService.findAll());
        return mv;
    }

    @PostMapping("/submit-book")
    public ModelAndView submitBook(@Valid @ModelAttribute Book book, BindingResult result, 
                                   @RequestParam String author, @RequestParam String publishDate, 
                                   @RequestParam String purchaseDate, @RequestParam Set<Long> genres) {
        ModelAndView mv = new ModelAndView();

        if (result.hasErrors()) {
            mv.setViewName("form");
            mv.addObject("genres", genreService.findAll());
            return mv;
        }


        Author bookAuthor = new Author();
        bookAuthor.setName(author);
        authorService.saveAuthor(bookAuthor);
        book.setAuthors(Set.of(bookAuthor));

        book.setPublicationDate(LocalDate.parse(publishDate));
        book.setPurchaseDate(LocalDate.parse(purchaseDate));

        Set<Genre> genreSet = new HashSet<>();
        for (Long genreId : genres) {
            Genre genre = genreService.findById(genreId);
            if (genre != null) {
                genreSet.add(genre);
            }
        }
        book.setGenres(genreSet);

        bookService.saveBook(book);

        mv.setViewName("results");
        mv.addObject("books", bookService.findAll());
        return mv;
    }

    //i think the error is here
    @GetMapping("/books")
    public ModelAndView listBooks() {
        ModelAndView mv = new ModelAndView("results");
        mv.addObject("books", bookService.findAll());
        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteBook(@PathVariable long id) {
        bookService.delete(id);
        ModelAndView mv = new ModelAndView("results");
        mv.addObject("books", bookService.findAll());
        return mv;
    }
}