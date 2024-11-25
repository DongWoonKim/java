package com.example.spring.webfrontadminservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonSerialize
public class CreateCatalogRequestDTO {
    private String isbn;
    private String title;
    private String author;
    private Double price;
}
