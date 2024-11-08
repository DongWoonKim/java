package com.example.spring.springbootbasicboard2.mapper;

import com.example.spring.springbootbasicboard2.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void signUp(Member member);
    Member signIn(String userId);
}
