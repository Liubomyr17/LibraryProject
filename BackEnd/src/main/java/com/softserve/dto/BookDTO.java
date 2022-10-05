package com.softserve.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Year;
import java.util.List;

@Data
public class BookDTO {

    private Long id;

    private String name;

    private Year year;

    private String isbn;

    private PublisherDTO publisher;

    private List<AuthorDTO> authors;
}
