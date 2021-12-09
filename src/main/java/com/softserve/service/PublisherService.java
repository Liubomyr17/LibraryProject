package com.softserve.service;

import com.softserve.model.Publisher;

import java.util.List;

public interface PublisherService {

    Publisher save(Publisher publisher);

    Publisher get(Long id);

    boolean update(Publisher publisher);

    boolean delete(Long id);

    List<Publisher> list();

}
