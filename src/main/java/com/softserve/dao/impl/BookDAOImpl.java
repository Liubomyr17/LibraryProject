package com.softserve.dao.impl;

import com.softserve.dao.BookDAO;
import com.softserve.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl extends CrudDAOImpl<Book> implements BookDAO {

    public BookDAOImpl(SessionFactory sessionFactory) {
        super(Book.class, sessionFactory);
    }

}