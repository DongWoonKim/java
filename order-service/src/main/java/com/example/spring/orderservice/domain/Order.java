package com.example.spring.orderservice.domain;

import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
public record Order() {
}
