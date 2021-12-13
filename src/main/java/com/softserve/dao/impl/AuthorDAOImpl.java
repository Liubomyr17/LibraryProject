package com.softserve.dao.impl;

import com.softserve.dao.AuthorDAO;
import com.softserve.model.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthorDAOImpl extends CrudDAOImpl<Author> implements AuthorDAO {

    @Override
    public List<Author> findByFirstName(String firstName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from " + classType.getName() + " where first_name=:firstName", classType);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }
}

