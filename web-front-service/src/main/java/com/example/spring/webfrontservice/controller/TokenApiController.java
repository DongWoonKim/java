package com.example.spring.webfrontservice.controller;

import com.example.spring.webfrontservice.dto.RefreshTokenClientResponseDTO;
import com.example.spring.webfrontservice.dto.RefreshTokenResponseDTO;
import com.example.spring.webfrontservice.service.TokenService;
import com.example.spring.webfrontservice.util.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenApiController {

    private final TokenService tokenService;

    @PostMapping("/refresh-token")
    ResponseEntity<?> refresh(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        RefreshTokenClientResponseDTO responseDTO = tokenService.refreshToken(request.getCookies());

        if (responseDTO == null || responseDTO.getStatus() != 1 ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh Token 유효하지 않습니다.");
        }

        CookieUtil.addCookie(response, "refreshToken", responseDTO.getRefreshToken(), 7*24*60*60);

        return ResponseEntity.ok(
                RefreshTokenResponseDTO.builder()
                        .accessToken(responseDTO.getAccessToken())
                        .status(responseDTO.getStatus())
                        .build()
        );
    }

}
