package com.softserve.service.impl;

import com.softserve.dao.PublisherDAO;
import com.softserve.model.Publisher;
import com.softserve.service.PublisherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherDAO publisherDAO;

    public PublisherServiceImpl(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }

    @Override
    @Transactional
    public Publisher save(Publisher publisher) {
        return publisherDAO.save(publisher);
    }

    @Override
    @Transactional
    public Publisher get(Long id) {
        return publisherDAO.get(id);
    }

    @Override
    @Transactional
    public boolean update(Publisher publisher) {
        publisherDAO.update(publisher);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        publisherDAO.delete(id);
        return true;
    }

    @Override
    @Transactional
    public List<Publisher> list() {
        return publisherDAO.list();
    }
}
