package com.softserve.controller;

import com.softserve.model.Book;
import com.softserve.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // All books
    @GetMapping()
    public ResponseEntity<List<Book>> list() {
        List<Book> books = bookService.list();
        return ResponseEntity.ok().body(books);
    }

    // Save the book
    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Book book) {
        Book b = bookService.save(book);
        if (book == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body("Book is created with id: " + b.toString());
    }

    // Get a single book
    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") Long id) {
        Book book = bookService.get(id);
        if (book == null) {
            throw new ResponseStatusException(NOT_FOUND, String.format("No resource found for id (%s)", id));
        }
        return ResponseEntity.ok().body(book);
    }

    // Update the book
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Book book) {
        bookService.update(book);
        return ResponseEntity.ok().body("Book has been updated successfully!");
    }

    // Delete the delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().body("Book has been deleted successfully!");
    }
}
