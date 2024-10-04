package com.example.tobi.springbootbasicboard.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardDetailResponseDTO {
    private String title;
    private String content;
    private String userId;
    private LocalDateTime created;
}
