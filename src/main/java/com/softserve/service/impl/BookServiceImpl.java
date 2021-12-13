package com.softserve.service.impl;

import com.softserve.dao.impl.BookDAOImpl;
import com.softserve.model.Book;
import com.softserve.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDAOImpl bookDAO;

    @Autowired
    public BookServiceImpl(BookDAOImpl bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public Book save(Book book) {
        bookDAO.save(book);
        return bookDAO.save(book);
    }

    @Override
    @Transactional
    public Book get(Long id) {
        return bookDAO.get(id);
    }

    @Override
    @Transactional
    public List<Book> list() {
        return bookDAO.list();
    }

    @Override
    @Transactional
    public Book update(Book book) {
        bookDAO.update(book);
        return book;
    }

    @Override
    @Transactional
    public Book delete(Long id) {
        return bookDAO.delete(id);
    }
}
