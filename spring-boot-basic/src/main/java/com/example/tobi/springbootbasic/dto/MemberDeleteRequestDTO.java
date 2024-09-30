package com.example.tobi.springbootbasic.dto;

import com.example.tobi.springbootbasic.model.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberDeleteRequestDTO {
    private Long id;
    private String userid;
    private String password;

    public User toUser() {
        return User.builder()
                .id(id)
                .userid(userid)
                .password(password)
                .build();
    }
}
