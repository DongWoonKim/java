package com.example.tobi.springbootbasicboard.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SignUpRequestDTO {
    private String userId;
    private String password;
    private String userName;
}
