package com.softserve.dao.impl;

import com.softserve.dao.CrudDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class CrudDAOImpl<T> implements CrudDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    Type t = getClass().getGenericSuperclass();
    ParameterizedType pt = (ParameterizedType) t;
    Class<T> classType = (Class<T>) pt.getActualTypeArguments()[0];


    public T save(T t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    public T get(Long id) {
        return sessionFactory.getCurrentSession().get(classType, id);
    }

    @Override
    public T update(T t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    public T delete(Long id) {
        T t = sessionFactory.getCurrentSession().get(classType, id);
        sessionFactory.getCurrentSession().delete(t);
        return t;
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
