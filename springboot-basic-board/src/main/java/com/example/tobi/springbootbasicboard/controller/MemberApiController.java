package com.example.tobi.springbootbasicboard.controller;

import com.example.tobi.springbootbasicboard.dto.SignUpRequestDTO;
import com.example.tobi.springbootbasicboard.dto.SignUpResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberApiController {

    @PostMapping("/join")
    public ResponseEntity<SignUpResponseDTO> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        return ResponseEntity.ok(
                SignUpResponseDTO.builder()
                        .url("/member/login")
                        .build()
        );
    }


}
