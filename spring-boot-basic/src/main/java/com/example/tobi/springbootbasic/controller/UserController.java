package com.example.tobi.springbootbasic.controller;

import com.example.tobi.springbootbasic.dto.MemberListResponseDTO;
import com.example.tobi.springbootbasic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAllUsers() {
        List<MemberListResponseDTO> users = userService.findAll();
        return "user-list";
    }

}
