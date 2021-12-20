package com.softserve.service;

import com.softserve.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    AuthorDTO save(AuthorDTO author);

    AuthorDTO get(Long id);

    List<AuthorDTO> list();

    List<AuthorDTO> findByName(String firstName);

    AuthorDTO update(AuthorDTO author);

    boolean delete(Long id);

}
