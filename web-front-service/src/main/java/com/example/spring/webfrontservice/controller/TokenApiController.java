package com.example.spring.webfrontservice.controller;

import com.example.spring.webfrontservice.dto.RefreshTokenClientResponseDTO;
import com.example.spring.webfrontservice.dto.RefreshTokenResponseDTO;
import com.example.spring.webfrontservice.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenApiController {

    private final TokenService tokenService;

    @PostMapping("/refresh")
    ResponseEntity<RefreshTokenResponseDTO> refresh() {
        return ResponseEntity.ok(tokenService.refreshToken().toRefreshTokenResponseDTO());
    }

}
