package com.softserve.controller;

import com.softserve.model.Book;
import com.softserve.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Save the book
    @PostMapping
    public ResponseEntity<Book> save(@RequestBody @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    // Get a single book
    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Book book = bookService.get(id);
        if (book == null) {
            throw new ResponseStatusException(NOT_FOUND, String.format("No resource found for id (%s)", id));
        }
        return ResponseEntity.ok().body(book);
    }

    // All books
    @GetMapping
    public ResponseEntity<List<Book>> list() {
        List<Book> books = bookService.list();
        return ResponseEntity.ok().body(books);
    }

    // Update the book
    @PutMapping
    public ResponseEntity<Book> update(@RequestBody @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bookService.update(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    // Delete the book
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bookService.delete(id);
        return ResponseEntity.ok().body("Book has been deleted successfully!");
    }
}
