package com.example.tobi.springbootbasic.controller;

import com.example.tobi.springbootbasic.dto.MemberCreateRequestDTO;
import com.example.tobi.springbootbasic.dto.MemberListResponseDTO;
import com.example.tobi.springbootbasic.model.User;
import com.example.tobi.springbootbasic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAllUsers(Model model) {
        List<MemberListResponseDTO> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "sign-up";
    }

    @PostMapping("/register")
    public String createUser(@RequestBody MemberCreateRequestDTO request) {
        System.out.println(request);
        return "redirect:/users";
    }

}
