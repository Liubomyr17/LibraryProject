package com.softserve.dao;

import java.util.List;

public interface CrudDAO<T> {

    T save(T t);

    T get(Long id);

    T update(T t);

    T delete(Long id);

    // TODO follow the CRUD order, list is READ
    List<T> list();

}
