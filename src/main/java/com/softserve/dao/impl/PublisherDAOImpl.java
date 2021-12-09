package com.softserve.dao.impl;

import com.softserve.dao.PublisherDAO;
import com.softserve.model.Publisher;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PublisherDAOImpl extends CrudDAOImpl<Publisher> implements PublisherDAO {

    public PublisherDAOImpl(SessionFactory sessionFactory) {
        super(Publisher.class, sessionFactory);
    }

}
