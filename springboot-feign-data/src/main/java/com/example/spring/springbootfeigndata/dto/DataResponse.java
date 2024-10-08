package com.example.spring.springbootfeigndata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DataResponse {
    private Long id;
    private String name;
    private int value;
}
