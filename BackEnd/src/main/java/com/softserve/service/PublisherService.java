package com.softserve.service;

import com.softserve.dto.PublisherDTO;

import java.util.List;

public interface PublisherService {

    PublisherDTO save(PublisherDTO publisher);

    PublisherDTO get(Long id);

    List<PublisherDTO> list();

    PublisherDTO update(PublisherDTO publisher);

    boolean delete(Long id);

}
