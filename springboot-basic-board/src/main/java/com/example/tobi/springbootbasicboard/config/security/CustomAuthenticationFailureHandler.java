package com.example.tobi.springbootbasicboard.config.security;

import com.example.tobi.springbootbasicboard.dto.SignInResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json; charset=utf-8");

        SignInResponseDTO build = SignInResponseDTO.builder()
                .isLoggedIn(false)
                .message("로그인 실패\n다시 로그인해주세요.")
                .url("/member/login")
                .build();

        response.getWriter().write(objectMapper.writeValueAsString(build));
    }
}
