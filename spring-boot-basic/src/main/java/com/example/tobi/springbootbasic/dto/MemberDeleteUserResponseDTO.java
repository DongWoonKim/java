package com.example.tobi.springbootbasic.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDeleteUserResponseDTO {
    private Long id;
    private String userid;
}
