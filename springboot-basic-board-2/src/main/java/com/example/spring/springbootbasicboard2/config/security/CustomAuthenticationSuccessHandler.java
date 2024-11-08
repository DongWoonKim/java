package com.example.spring.springbootbasicboard2.config.security;

import com.example.spring.springbootbasicboard2.dto.SignInResponseDTO;
import com.example.spring.springbootbasicboard2.model.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();// CustomUserDetails 가져오기
        Member member = userDetails.getMember();

        // 세션설정
        HttpSession session = request.getSession();
        session.setAttribute("userId", member.getUserId());
        session.setAttribute("userName", member.getUserName());

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json; charset=utf-8");

        SignInResponseDTO build = SignInResponseDTO.builder()
                .isLoggedIn(true)
                .message("로그인 성공")
                .url("/")
                .userId(member.getUserId())
                .userName(member.getUserName())
                .build();

        response.getWriter().write(
                objectMapper.writeValueAsString(build)
        );
    }
}
