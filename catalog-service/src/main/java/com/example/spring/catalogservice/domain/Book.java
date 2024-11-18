package com.example.spring.catalogservice.domain;

import lombok.Builder;

@Builder
public record Book(
   String isbn,
   String title,
   String author,
   Double price
) {}
