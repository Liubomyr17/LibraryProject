package com.softserve.service.impl;

import com.softserve.dao.PublisherDAO;
import com.softserve.dto.PublisherDTO;
import com.softserve.mapper.PublisherMapper;
import com.softserve.service.PublisherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherDAO publisherDAO;

    public PublisherServiceImpl(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }

    @Override
    @Transactional
    public PublisherDTO save(PublisherDTO publisher) {
        return PublisherMapper.INSTANCE.toDto(publisherDAO.save(PublisherMapper.INSTANCE.toEntity(publisher)));
    }

    @Override
    @Transactional
    public PublisherDTO get(Long id) {
        return PublisherMapper.INSTANCE.toDto(publisherDAO.get(id));
    }

    @Override
    @Transactional
    public List<PublisherDTO> list() {
        return publisherDAO.list().stream().map(PublisherMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PublisherDTO update(PublisherDTO publisher) {
        return PublisherMapper.INSTANCE.toDto(publisherDAO.update(PublisherMapper.INSTANCE.toEntity(publisher)));
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        publisherDAO.delete(id);
        return true;
    }
}
