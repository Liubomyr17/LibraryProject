package com.softserve.service;

import com.softserve.model.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    Book get(Long id);

    Book update(Book book);

    Book delete(Long id);

    List<Book> list();


}
