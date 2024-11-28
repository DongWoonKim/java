package com.example.spring.authservice.controller;

import com.example.spring.authservice.dto.UserJoinRequestDTO;
import com.example.spring.authservice.dto.UserJoinResponseDTO;
import com.example.spring.authservice.dto.UserLoginRequestDTO;
import com.example.spring.authservice.dto.UserLoginResponseDTO;
import com.example.spring.authservice.service.UserService;
import com.example.spring.authservice.utils.CookieUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auths")
public class UserApiController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public UserLoginResponseDTO login(
            HttpServletResponse response,
            @RequestBody UserLoginRequestDTO loginRequest
    ) {
        log.info("login");
        UserLoginResponseDTO logined = userService.login(loginRequest.getUserId(), loginRequest.getPassword());

        CookieUtil.addCookie(response, "refreshToken", logined.getRefreshToken(), 7 * 24 * 60 * 60);
        logined.setRefreshToken(null);

        return logined;
    }

    @PostMapping("/join")
    public UserJoinResponseDTO join(@RequestBody UserJoinRequestDTO joinRequest) {
        log.info("join :: {}", joinRequest);
        return userService.join( joinRequest.toUser(bCryptPasswordEncoder) );
    }

}
