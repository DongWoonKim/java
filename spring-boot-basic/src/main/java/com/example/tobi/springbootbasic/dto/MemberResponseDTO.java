package com.example.tobi.springbootbasic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String userid;
}
