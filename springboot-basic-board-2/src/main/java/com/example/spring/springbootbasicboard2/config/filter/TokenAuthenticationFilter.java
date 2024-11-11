package com.example.spring.springbootbasicboard2.config.filter;

import com.example.spring.springbootbasicboard2.config.jwt.TokenProvider;
import com.example.spring.springbootbasicboard2.model.Member;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 검증 로직
        String requestURI = request.getRequestURI();
        log.info("requestURI: {}", requestURI);
        if (
                "/member/login".equals(requestURI)
                || "/js/signIn.js".equals(requestURI)
                || "/css/signIn.css".equals(requestURI)
        ) {
            chain.doFilter(request, response);
            return;
        }

        String token = resolveToken(request);

        if (token == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

        int validateToken = tokenProvider.validateToken(token);
        if (validateToken == 1) {
            // 인증정보설정 로직...
            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            Member member = tokenProvider.getTokenDetails(token);
            request.setAttribute("member", member);

            chain.doFilter(request, response);
        } else if (validateToken == 2) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }

    }
    
    private String resolveToken(HttpServletRequest request) {
        
        // Authorization 헤더에서 JWT토큰 추출
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }
    
}
