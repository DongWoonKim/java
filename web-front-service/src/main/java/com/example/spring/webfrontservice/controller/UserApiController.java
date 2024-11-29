package com.example.spring.webfrontservice.controller;

import com.example.spring.webfrontservice.dto.*;
import com.example.spring.webfrontservice.service.UserService;
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
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        LoginClientResponseDTO logined = userService.login(loginRequestDTO);
        return ResponseEntity.ok(logined.toLoginResponseDTO());
    }

}
