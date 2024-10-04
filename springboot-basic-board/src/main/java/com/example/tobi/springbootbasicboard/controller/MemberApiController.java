package com.example.tobi.springbootbasicboard.controller;

import com.example.tobi.springbootbasicboard.dto.SignInRequestDTO;
import com.example.tobi.springbootbasicboard.dto.SignInResponseDTO;
import com.example.tobi.springbootbasicboard.dto.SignUpRequestDTO;
import com.example.tobi.springbootbasicboard.dto.SignUpResponseDTO;
import com.example.tobi.springbootbasicboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<SignUpResponseDTO> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        memberService.signUp(signUpRequestDTO.toMember());
        return ResponseEntity.ok(
                SignUpResponseDTO.builder()
                        .url("/member/login")
                        .build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<SignInResponseDTO> signIn(@RequestBody SignInRequestDTO signInRequestDTO) {
        return ResponseEntity.ok(
                memberService.signIn(signInRequestDTO.toMember())
        );
    }

}
