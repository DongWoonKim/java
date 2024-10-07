package com.example.tobi.springbootbasicboard.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Board {
    private Long id;
    private String title;
    private String content;
    private String userId;
    private String filePath;
    private LocalDateTime created;
}
