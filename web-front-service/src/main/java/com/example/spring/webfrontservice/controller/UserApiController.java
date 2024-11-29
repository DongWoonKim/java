package com.example.spring.webfrontservice.controller;

import com.example.spring.webfrontservice.dto.*;
import com.example.spring.webfrontservice.service.UserService;
import com.example.spring.webfrontservice.util.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<JoinResponseDTO> join(@RequestBody JoinRequestDTO joinRequestDTO) {
        JoinClientResponseDTO joined = userService.join(joinRequestDTO);
        return ResponseEntity.ok(joined.toJoinResponseDTO());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            HttpServletResponse response,
            @RequestBody LoginRequestDTO loginRequestDTO
    ) {
        LoginClientResponseDTO logined = userService.login(loginRequestDTO);

        if (logined != null && logined.isLoggedIn()) {
            // Refresh Token을 HttpOnly 쿠키에 저장
            CookieUtil.addCookie(response, "refreshToken", logined.getRefreshToken(), 7 * 24 * 60 * 60);
        }

        assert logined != null;
        return ResponseEntity.ok(logined.toLoginResponseDTO());
    }

}
