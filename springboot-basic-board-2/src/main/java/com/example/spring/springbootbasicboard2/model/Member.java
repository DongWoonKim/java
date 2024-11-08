package com.example.spring.springbootbasicboard2.model;

import com.example.spring.springbootbasicboard2.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Member {
    private long id;
    private String userId;
    private String password;
    private String userName;
    private Role role;
}
