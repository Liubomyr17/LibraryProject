package com.softserve.service;

import com.softserve.model.Publisher;

import java.util.List;

public interface PublisherService {

    Publisher save(Publisher publisher);

    Publisher get(Long id);

    Publisher update(Publisher publisher);

    Publisher delete(Long id);

    List<Publisher> list();

}
