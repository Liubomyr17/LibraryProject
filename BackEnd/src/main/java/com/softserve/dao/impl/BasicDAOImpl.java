package com.softserve.dao.impl;

import com.softserve.dao.BasicDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BasicDAOImpl<T> implements BasicDAO<T> {

    private final Class<T> classType;

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    protected BasicDAOImpl() {
        this.classType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T save(T t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public T get(Long id) {
        return sessionFactory.getCurrentSession().get(classType, id);
    }

    @Override
    public List<T> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(classType);
        Root<T> root = cq.from(classType);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }

    @Override
    public T update(T t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public boolean delete(Long id) {
        T type = sessionFactory.getCurrentSession().get(classType, id);
        sessionFactory.getCurrentSession().delete(type);
        return true;
    }
}