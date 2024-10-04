package com.example.tobi.springbootbasicboard.dto;

import com.example.tobi.springbootbasicboard.model.Member;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SignInRequestDTO {
    private String userId;
    private String password;

    public Member toMember() {
        return Member.builder()
                .userId(userId)
                .password(password)
                .build();
    }
}
