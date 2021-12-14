// TODO format this class / optimize imports
package com.softserve.service.impl;

import com.softserve.dao.impl.AuthorDAOImpl;
import com.softserve.model.Author;
import com.softserve.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAOImpl authorDAO;

    @Autowired
    // TODO work with abstraction rather than implementation
    public AuthorServiceImpl(AuthorDAOImpl authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    @Transactional
    public Author save(Author author) {
        // TODO 2 creations
        authorDAO.save(author);
        return authorDAO.save(author);
    }

    @Override
    @Transactional
    public Author get(Long id) {
        return authorDAO.get(id);
    }

    @Override
    @Transactional
    public List<Author> list() {
        return authorDAO.list();
    }

    @Override
    @Transactional
    public List<Author> findByName(String firstName) {
        return authorDAO.findByFirstName(firstName);
    }

    @Override
    @Transactional
    public Author update(Author author) {
        authorDAO.update(author);
        // TODO the line above could be returned
        return author;
    }

    @Override
    @Transactional
    public Author delete(Long id) {
        return authorDAO.delete(id);
    }
}
