package com.softserve.controller;

import com.softserve.model.Publisher;
import com.softserve.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> save(@RequestBody Publisher publisher) {
        Publisher publish = publisherService.save(publisher);
        return ResponseEntity.ok().body("Publisher is created with id: " + publish.toString());
    }

    // Get a single publisher
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> get(@PathVariable("id") Long id) {
        Publisher publisher = publisherService.get(id);
        return ResponseEntity.ok().body(publisher);
    }

    // Update the author
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Publisher publisher) {
        publisherService.update(publisher);
        return ResponseEntity.ok().body("Author has been updated successfully!");
    }

    // Delete the author
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        publisherService.delete(id);
        return ResponseEntity.ok().body("Publisher has been deleted successfully!");
    }
}
