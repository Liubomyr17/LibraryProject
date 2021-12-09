package com.softserve.dao;

import java.util.List;

public interface CrudDAO<T> {

    T save(T t);

    T get(Long id);

    boolean update(T t);

    boolean delete(Long id);

    List<T> list();
}
