package com.softserve.mapper;

import com.softserve.dto.PublisherDTO;
import com.softserve.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    PublisherDTO toDto(Publisher publisher);

    Publisher toEntity(PublisherDTO publisherDTO);
}
