package com.softserve.service.impl;

import com.softserve.dao.BookDAO;
import com.softserve.dto.BookDTO;
import com.softserve.mapper.BookMapper;
import com.softserve.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public BookDTO save(BookDTO book) {
        return BookMapper.INSTANCE.toDto(bookDAO.save(BookMapper.INSTANCE.toEntity(book)));
    }

    @Override
    @Transactional
    public BookDTO get(Long id) {
        return BookMapper.INSTANCE.toDto(bookDAO.get(id));
    }

    @Override
    @Transactional
    public List<BookDTO> list() {
            return bookDAO.list().stream().map(BookMapper.INSTANCE::toDto).collect(Collectors.toList());
        }

    @Override
    @Transactional
    public BookDTO update(BookDTO book) {
       return BookMapper.INSTANCE.toDto(bookDAO.update(BookMapper.INSTANCE.toEntity(book)));
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        bookDAO.delete(id);
        return true;
    }

}
