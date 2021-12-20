package com.softserve.dao.impl;

import com.softserve.dao.BookDAO;
import com.softserve.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl extends BasicDAOImpl<Book> implements BookDAO {
}