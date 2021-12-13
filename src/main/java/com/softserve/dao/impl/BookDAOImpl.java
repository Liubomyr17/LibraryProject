package com.softserve.dao.impl;

import com.softserve.dao.BookDAO;
import com.softserve.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl extends CrudDAOImpl<Book> implements BookDAO {

    @Override
    public Book get(Long id) {
        Book book = super.get(id);
        book.getAuthors().size();
        return book;
    }

    @Override
    public List<Book> list() {
        List<Book> books = super.list();
        for (Book book : books) {
            book.getAuthors().size();
        }
        return books;
    }
}