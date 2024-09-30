package com.example.tobi.springbootbasic.dto;

import com.example.tobi.springbootbasic.model.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberUpdateRequestDTO {
    private Long id;
    private String name;
    private String email;
    private String userid;

    public User toUser() {
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .userid(userid)
                .build();
    }
}
