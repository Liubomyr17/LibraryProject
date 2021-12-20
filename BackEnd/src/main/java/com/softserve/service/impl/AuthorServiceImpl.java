package com.softserve.service.impl;

import com.softserve.dao.AuthorDAO;
import com.softserve.dto.AuthorDTO;
import com.softserve.mapper.AuthorMapper;
import com.softserve.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    @Transactional
    public AuthorDTO save(AuthorDTO author) {
        return AuthorMapper.INSTANCE.toDto(authorDAO.save(AuthorMapper.INSTANCE.toEntity(author)));
    }

    @Override
    @Transactional
    public AuthorDTO get(Long id) {
        return AuthorMapper.INSTANCE.toDto(authorDAO.get(id));
    }

    @Override
    @Transactional
    public List<AuthorDTO> list() {
        return authorDAO.list().stream().map(AuthorMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<AuthorDTO> findByName(String firstName) {
        return authorDAO.findByFirstName(firstName).stream().map(AuthorMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AuthorDTO update(AuthorDTO author) {
        return AuthorMapper.INSTANCE.toDto(authorDAO.update(AuthorMapper.INSTANCE.toEntity(author)));
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        authorDAO.delete(id);
        return true;
    }
}