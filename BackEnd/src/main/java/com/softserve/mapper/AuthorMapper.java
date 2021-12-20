package com.softserve.mapper;

import com.softserve.dto.AuthorDTO;
import com.softserve.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO toDto(Author author);

    Author toEntity(AuthorDTO authorDTO);
}


