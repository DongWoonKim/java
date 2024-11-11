package com.example.spring.springbootbasicboard2.service;

import com.example.spring.springbootbasicboard2.dto.SignInResponseDTO;
import com.example.spring.springbootbasicboard2.mapper.MemberMapper;
import com.example.spring.springbootbasicboard2.model.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final AuthenticationManager authenticationManager;

    public void signUp(Member member) {
        memberMapper.signUp(member);
    }

    public SignInResponseDTO signIn(String username, String password) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        return null;
    }


    private SignInResponseDTO makeSignInRequestDTO(boolean isloggedIn, String message, String url, Member member) {
        return SignInResponseDTO.builder()
                .isLoggedIn(isloggedIn)
                .message(message)
                .url(url)
                .userId(isloggedIn ? member.getUserId() : null)
                .userName(isloggedIn ? member.getUserName() : null)
                .build();
    }

}
