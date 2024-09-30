package com.example.tobi.springbootbasic.service;

import com.example.tobi.springbootbasic.dto.MemberResponseDTO;
import com.example.tobi.springbootbasic.mapper.UserMapper;
import com.example.tobi.springbootbasic.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<MemberResponseDTO> findAll() {
        List<User> users = userMapper.findAll();

        // 방법.1
//        List<MemberListResponseDTO> members = new ArrayList<>();
//        for (User user : users) {
//            members.add(user.toMemberListResponseDTO());
//        }
//        return members;

        // 방법2 : Java Stream & Lambda
        return users.stream()
                .map(User::toMemberResponseDTO)
                .collect(Collectors.toList());
    }

    public MemberResponseDTO findById(Long id) {
        return userMapper.findById(id)
                .toMemberResponseDTO();
    }

    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }
}
