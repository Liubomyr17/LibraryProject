package com.softserve.dao;

import java.util.List;

public interface CrudDAO<T> {

    T save(T t);

    T get(Long id);

    List<T> list();

    T update(T t);

    T delete(Long id);

}
