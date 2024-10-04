package com.example.tobi.springbootbasicboard.service;

import com.example.tobi.springbootbasicboard.dto.SignInResponseDTO;
import com.example.tobi.springbootbasicboard.mapper.MemberMapper;
import com.example.tobi.springbootbasicboard.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void signUp(Member member) {
        memberMapper.signUp(member);
    }

    public SignInResponseDTO signIn(Member member) {
        Member getMember = memberMapper.signIn(member.getUserId());
        String message = "로그인이 성공했습니다.";
        if (getMember == null) {
            message = "존재하지 않는 회원입니다.";

            return SignInResponseDTO.builder()
                    .isLoggedIn(false)
                    .message(message)
                    .build();
        }

        if (
                getMember != null &&
                !member.getPassword().equals(getMember.getPassword())
        ) {
            message = "비밀번호가 틀렸습니다.";

            return SignInResponseDTO.builder()
                    .isLoggedIn(false)
                    .message(message)
                    .build();
        }

        return SignInResponseDTO.builder()
                .isLoggedIn(true)
                .message(message)
                .url("/")
                .userId(getMember.getUserId())
                .userName(getMember.getUserName())
                .build();
    }

}
