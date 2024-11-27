package com.example.spring.authservice.mapper;

import com.example.spring.authservice.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int saveUser(User user);
    User findUserByUserId(String userId);
}
