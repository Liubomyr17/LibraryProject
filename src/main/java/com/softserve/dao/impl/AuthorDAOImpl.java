package com.softserve.dao.impl;

import com.softserve.dao.AuthorDAO;
import com.softserve.model.Author;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AuthorDAOImpl extends CrudDAOImpl<Author> implements AuthorDAO {

    @Override
    public List<Author> findByFirstName(String firstName) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);
        Predicate authorFirstName = (cb.equal(root.get("firstName"), firstName));
        cq.where(authorFirstName);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }
}
