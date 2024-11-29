package com.example.spring.webfrontservice.dto;

import lombok.Getter;

@Getter
public class LoginClientResponseDTO {
    private boolean loggedIn;
    private String userName;
    private String userId;
    private String accessToken;

    public LoginResponseDTO toLoginResponseDTO() {
        return LoginResponseDTO.builder()
            .userName(userName)
            .userId(userId)
            .accessToken(accessToken)
            .url(loggedIn ? "/webs" : "/webs/login")
            .message(loggedIn ? "로그인 성공!" : "로그인 실패!")
            .build();
    }
}
