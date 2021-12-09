package com.softserve.dao.impl;

import com.softserve.dao.CrudDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class CrudDAOImpl<T> implements CrudDAO<T> {

    private final Class<T> classType;
    protected final SessionFactory sessionFactory;

    protected CrudDAOImpl(Class<T> classType, SessionFactory sessionFactory) {
        this.classType = classType;
        this.sessionFactory = sessionFactory;
    }

    public T save(T t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    public T get(Long id) {
        return sessionFactory.getCurrentSession().get(classType, id);
    }

    @Override
    public boolean update(T t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return true;
    }


    public boolean delete(Long id) {
        T t = sessionFactory.getCurrentSession().get(classType, id);
        sessionFactory.getCurrentSession().delete(t);
        return true;
    }

    public List<T> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(classType);
        Root<T> root = cq.from(classType);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }
}
