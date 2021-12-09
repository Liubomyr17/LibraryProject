package com.softserve.dao.impl;

import com.softserve.dao.AuthorDAO;
import com.softserve.model.Author;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAOImpl extends CrudDAOImpl<Author> implements AuthorDAO {

    public AuthorDAOImpl(SessionFactory sessionFactory) {
        super(Author.class, sessionFactory);
    }

}
