package com.softserve.service;

import com.softserve.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO save(BookDTO book);

    BookDTO get(Long id);

    List<BookDTO> list();

    BookDTO update(BookDTO book);

    boolean delete(Long id);

}
