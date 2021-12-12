package com.softserve.controller;

import com.softserve.model.Publisher;
import com.softserve.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    // All publishers
    @GetMapping()
    public List<Publisher> list() {
        return publisherService.list();
    }

    // Save the publisher
    @PostMapping()
    public ResponseEntity<?> save(@RequestBody @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(publisherService.save(publisher), HttpStatus.OK);
    }

    // Get a single publisher
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> get(@PathVariable("id") Long id) {
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Publisher publisher = publisherService.get(id);
        if (publisher == null) {
            throw new ResponseStatusException(NOT_FOUND, String.format("No resource found for id (%s)", id));
        }
        return ResponseEntity.ok().body(publisher);
    }

    // Update the publisher
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody @Valid Publisher publisher, BindingResult result) {
        if (!publisherService.update(publisher) || result.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    // Delete the publisher
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        publisherService.delete(id);
        return ResponseEntity.ok().body("Publisher has been deleted successfully!");
    }
}
