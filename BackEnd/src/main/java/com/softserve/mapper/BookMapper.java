package com.softserve.mapper;

import com.softserve.dto.BookDTO;
import com.softserve.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDto(Book book);

    Book toEntity(BookDTO bookDTO);
}
