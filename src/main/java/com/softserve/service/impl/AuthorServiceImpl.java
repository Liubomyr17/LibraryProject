package com.softserve.service.impl;

import com.softserve.dao.AuthorDAO;
import com.softserve.model.Author;
import com.softserve.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    @Transactional
    public Author save(Author author) {
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
        return author;
    }

    @Override
    @Transactional
    public Author delete(Long id) {
        return authorDAO.delete(id);
    }
}