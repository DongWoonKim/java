package com.example.tobi.springbootbasicboard.service;

import com.example.tobi.springbootbasicboard.dto.SignInResponseDTO;
import com.example.tobi.springbootbasicboard.mapper.MemberMapper;
import com.example.tobi.springbootbasicboard.model.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void signUp(Member member) {
        memberMapper.signUp(member);
    }

    public SignInResponseDTO signIn(Member member, HttpSession session) {
        Member getMember = memberMapper.signIn(member.getUserId());
        if (getMember == null) {
            return makeSignInRequestDTO(false, "존재하지 않는 회원입니다.", null, null);
        }

        if ( !member.getPassword().equals(getMember.getPassword()) ) {
            return makeSignInRequestDTO(false, "비밀번호가 틀렸습니다.", null, null);
        }
        
        // 세션 설정
        session.setAttribute("userId", getMember.getUserId());
        session.setAttribute("userName", getMember.getUserName());

        return makeSignInRequestDTO(true, "로그인이 성공했습니다.", "/", member);
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
