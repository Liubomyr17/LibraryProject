package com.softserve.controller;

import com.softserve.model.Author;
import com.softserve.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorService authorService;

    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // All authors
    @GetMapping()
    public ResponseEntity<List<Author>> list() {
        List<Author> authors = authorService.list();
        return ResponseEntity.ok().body(authors);
    }

    // Save the author
    @PostMapping()
       public ResponseEntity<?> save(@RequestBody Author author) {
        Author auth = authorService.save(author);
        if (author == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body("Author is created with id: " + auth.toString());
    }

    // Get a single author
    @GetMapping("/{id}")
    public ResponseEntity<Author> get(@PathVariable("id") Long id) {
        Author author = authorService.get(id);
        if (author == null) {
            throw new ResponseStatusException(NOT_FOUND, String.format("No resource found for id (%s)", id));
        }
        return ResponseEntity.ok().body(author);
    }

    // Update the author
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Author author) {
            authorService.update(author);
            return ResponseEntity.ok().body("Author has been updated successfully!");
    }

    // Delete the author
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        authorService.delete(id);
        return ResponseEntity.ok().body("Author has been deleted successfully!");
    }
}