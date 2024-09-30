package com.example.tobi.springbootbasic.controller;

import com.example.tobi.springbootbasic.dto.*;
import com.example.tobi.springbootbasic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAllUsers(Model model) {
        List<MemberResponseDTO> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "sign-up";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        // 로직을 추가... -> id를 조건으로 조회한 데이터를
        // 프론트(수정)화면에 뿌릴 것.
        MemberResponseDTO user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @GetMapping("/delete")
    public String deleteUser(
            @RequestParam("id") Long id,
            @RequestParam("userid") String userid,
            Model model
    ) {
        model.addAttribute(
                "user",
                MemberDeleteUserResponseDTO.builder()
                    .id(id)
                    .userid(userid)
                    .build()
        );
        return "user-delete";
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody MemberDeleteRequestDTO request) {
        userService.deleteUser(request.toUser());
        return ResponseEntity.ok(HttpStatus.OK);
    }

//    @GetMapping("/update")
//    public String updateForm(@RequestParam("id") Long id, Model model) {
//        System.out.println("id :: " + id);
//        return "user-update";
//    }

    @PostMapping("/register")
    public String createUser(@RequestBody MemberCreateRequestDTO request) {
        userService.createUser( request.toUser() );
        return "redirect:/users";
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody MemberUpdateRequestDTO request) {
        userService.updateUser( request.toUser() );
        return ResponseEntity.ok("Updated");
    }


}
