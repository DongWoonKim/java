package com.example.tobi.springbootbasic.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MemberCreateRequestDTO {
    private String name;
    private String email;
    private String userid;
    private String password;
}
