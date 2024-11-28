package com.example.spring.webfrontservice.controller;

import com.example.spring.webfrontservice.dto.JoinClientResponseDTO;
import com.example.spring.webfrontservice.dto.JoinRequestDTO;
import com.example.spring.webfrontservice.dto.JoinResponseDTO;
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

}
