package com.softserve.controller;

import com.softserve.dto.AuthorDTO;
import com.softserve.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorService authorService;

    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Save the author
    @PostMapping
    public ResponseEntity<AuthorDTO> save(@RequestBody @Valid AuthorDTO author, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(authorService.save(author), HttpStatus.CREATED);
    }

    // Get a single author
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> get(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AuthorDTO author = authorService.get(id);
        if (author == null) {
            throw new ResponseStatusException(NOT_FOUND, String.format("No resource found for id (%s)", id));
        }
        return ResponseEntity.ok().body(author);
    }

    // All authors
    @GetMapping
    public ResponseEntity<List<AuthorDTO>> list() {
        List<AuthorDTO> authors = authorService.list();
        if (authors.isEmpty()) {
            System.out.println("List of Authors is empty");
        }
        return ResponseEntity.ok().body(authors);
    }

    @GetMapping("/name")
    public ResponseEntity<List<AuthorDTO>> getAuthorByFirstName(@RequestParam String firstName) {
        return new ResponseEntity<>(authorService.findByName(firstName), HttpStatus.OK);
    }

    // Update the author
    @PutMapping
    public ResponseEntity<AuthorDTO> update(@RequestBody @Valid AuthorDTO author, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        authorService.update(author);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    // Delete the author
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        authorService.delete(id);
        return ResponseEntity.ok().body("Author has been deleted successfully!");
    }
}