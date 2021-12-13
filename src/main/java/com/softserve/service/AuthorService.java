package com.softserve.service;

import com.softserve.model.Author;

import java.util.List;

public interface AuthorService {

    Author save(Author author);

    Author get(Long id);

    Author update(Author author);

    Author delete(Long id);

    List<Author> list();

    List<Author> findByName(String firstName);

}
