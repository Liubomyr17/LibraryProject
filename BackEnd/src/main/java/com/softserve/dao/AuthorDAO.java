package com.softserve.dao;

import com.softserve.model.Author;

import java.util.List;

public interface AuthorDAO extends BasicDAO<Author> {

    List<Author> findByFirstName(String firstName);

}
