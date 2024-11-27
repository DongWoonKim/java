package com.example.spring.authservice.controller;

import com.example.spring.authservice.dto.*;
import com.example.spring.authservice.service.TokenService;
import com.example.spring.authservice.utils.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auths")
public class TokenApiController {

    private final TokenService tokenService;

    @PostMapping("/refresh")
    public RefreshTokenResponseDTO refreshToken(
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO
    ) {
        log.info("refresh");
        RefreshTokenResponseDTO refreshTokenResponseDTO = tokenService.refreshToken(refreshTokenRequestDTO.getRefreshToken());
        if (refreshTokenResponseDTO.getStatus() == 1) {
            CookieUtil.addCookie(response, "refreshToken", refreshTokenResponseDTO.getRefreshToken(), 7 * 24 * 60 * 60);
            refreshTokenResponseDTO.setRefreshToken(null);
        } else {
            CookieUtil.deleteCookie(request, response, "refreshToken");
        }

        return refreshTokenResponseDTO;
    }

    @PostMapping("/validToken")
    public ValidTokenResponseDTO validToken(@RequestBody ValidTokenRequestDTO validTokenRequestDTO) {
        log.info("validToken");
        return tokenService.validToken(validTokenRequestDTO.getToken());
    }

    @PostMapping("/claims")
    public ClaimsResponseDTO claims(@RequestBody ClaimsRequestDTO claimsRequestDTO) {
        log.info("claims");
        return tokenService.getAuthentication(claimsRequestDTO.getToken());
    }

}
