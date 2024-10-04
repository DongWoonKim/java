package com.example.tobi.springbootbasicboard.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Board {
    private Long id;
    private String title;
    private String userId;
    private LocalDateTime createdAt;
}
