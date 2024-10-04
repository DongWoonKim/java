package com.example.tobi.springbootbasicboard.mapper;

import com.example.tobi.springbootbasicboard.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void signUp(Member member);
    Member signIn(String userId);
}
