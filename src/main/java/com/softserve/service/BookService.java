package com.softserve.service;

import com.softserve.model.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    Book get(Long id);

    List<Book> list();

    Book update(Book book);

    Book delete(Long id);

}
