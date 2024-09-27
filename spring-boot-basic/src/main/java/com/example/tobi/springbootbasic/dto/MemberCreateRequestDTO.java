package com.example.tobi.springbootbasic.dto;

import com.example.tobi.springbootbasic.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
public class MemberCreateRequestDTO {
    private String name;
    private String email;
    private String userid;
    private String password;

    public User toUser() {
        return User.builder()
                .name(name)
                .email(email)
                .userid(userid)
                .password(password)
                .build();
    }
}
