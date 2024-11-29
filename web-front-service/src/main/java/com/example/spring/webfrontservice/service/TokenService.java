package com.example.spring.webfrontservice.service;

import com.example.spring.webfrontservice.client.AuthClient;
import com.example.spring.webfrontservice.dto.RefreshTokenClientResponseDTO;
import com.example.spring.webfrontservice.dto.RefreshTokenRequestDTO;
import com.example.spring.webfrontservice.util.CookieUtil;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final AuthClient authClient;

    public RefreshTokenClientResponseDTO refreshToken(Cookie[] cookies) {
        String refreshTokenFromCookies = CookieUtil.getTokenFromCookies(cookies, "refreshToken");

        if (refreshTokenFromCookies == null) {
            return null;
        }

        RefreshTokenRequestDTO build = RefreshTokenRequestDTO.builder()
                .refreshToken(refreshTokenFromCookies)
                .build();

        return authClient.refresh(build);
    }

}
