// TODO format this class / optimize imports
package com.softserve.dao;

import com.softserve.model.Author;

import java.util.List;

public interface AuthorDAO extends CrudDAO<Author> {

    List<Author> findByFirstName(String firstName);

}
