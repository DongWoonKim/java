package com.example.spring.webfrontservice.client;

import com.example.spring.webfrontservice.dto.JoinClientResponseDTO;
import com.example.spring.webfrontservice.dto.JoinRequestDTO;
import com.example.spring.webfrontservice.dto.LoginClientResponseDTO;
import com.example.spring.webfrontservice.dto.LoginRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authClient", url = "${polar.auth-service-url}")
public interface AuthClient {

    @PostMapping("/join")
    JoinClientResponseDTO join(@RequestBody JoinRequestDTO joinRequestDTO);

    @PostMapping("/login")
    LoginClientResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO);

}
