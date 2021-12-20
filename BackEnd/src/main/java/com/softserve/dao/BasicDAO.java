package com.softserve.dao;

import java.util.List;

public interface BasicDAO<T> {

    T save(T t);

    T get(Long id);

    List<T> list();

    T update(T t);

    boolean delete(Long id);

}
