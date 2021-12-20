package com.softserve.dao.impl;

import com.softserve.dao.BookDAO;
import com.softserve.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl extends CrudDAOImpl<Book> implements BookDAO {
