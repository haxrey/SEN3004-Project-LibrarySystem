package com.example.demo.controller;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    private GenreService genreService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/form")
    public ModelAndView displayForm() {
        ModelAndView mv = new ModelAndView("form");
        mv.addObject("genres", genreService.findAll());
        return mv;
    }

    @PostMapping("/submit-book")
    public String submitBook(@RequestParam String title,
            @RequestParam List<String> authors,
            @RequestParam String publishDate,
            @RequestParam String purchaseDate,
            @RequestParam String isbn,
            @RequestParam double price,
            @RequestParam Set<Long> genres) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPublicationDate(LocalDate.parse(publishDate));
        book.setPurchaseDate(LocalDate.parse(purchaseDate));
        book.setPrice(price);

        Set<Author> authorSet = new HashSet<>();
        for (String authorName : authors) {
            Author author = new Author();
            author.setName(authorName);
            authorService.saveAuthor(author);
            authorSet.add(author);
        }
        book.setAuthors(authorSet);

        Set<Genre> genreSet = new HashSet<>();
        for (Long genreId : genres) {
            Genre genre = genreService.findById(genreId);
            if (genre != null) {
                genreSet.add(genre);
            }
        }
        book.setGenres(genreSet);

        bookService.saveBook(book);
        return "redirect:/results";
    }

    @GetMapping("/results")
    public ModelAndView displayResults() {
        ModelAndView mv = new ModelAndView("results");
        mv.addObject("books", bookService.findAllBooks());
        return mv;
    }

    @GetMapping("/edit")
    public String showEditBookForm(@RequestParam("bookId") Long bookId, Model model) {
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        model.addAttribute("genres", genreService.findAll());
        return "edit";
    }

    @PostMapping("/update-book-details")
    public String updateBookDetails(@RequestParam("bookId") Long bookId,
            @RequestParam("title") String title,
            @RequestParam("authors") List<String> authors,
            @RequestParam("publishDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate publishDate,
            @RequestParam("purchaseDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate purchaseDate,
            @RequestParam("isbn") String isbn,
            @RequestParam("price") Double price,
            @RequestParam("genres") List<Long> genreIds) {

        Book book = bookService.getBookById(bookId);
        if (book != null) {
            book.setTitle(title);
            book.setPublicationDate(publishDate);
            book.setPurchaseDate(purchaseDate);
            book.setIsbn(isbn);
            book.setPrice(price);

            // Update authors
            Set<Author> authorSet = new HashSet<>();
            for (String authorName : authors) {
                Author author = authorService.findByName(authorName);
                if (author == null) {
                    author = new Author();
                    author.setName(authorName);
                    authorService.save(author);
                }
                authorSet.add(author);
            }
            book.setAuthors(authorSet);

            // Update genres
            Set<Genre> genreSet = new HashSet<>();
            for (Long genreId : genreIds) {
                Genre genre = genreService.getGenreById(genreId);
                genreSet.add(genre);
            }
            book.setGenres(genreSet);

            bookService.updateBook(book);
        }

        return "redirect:/results";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/results";
    }
}
