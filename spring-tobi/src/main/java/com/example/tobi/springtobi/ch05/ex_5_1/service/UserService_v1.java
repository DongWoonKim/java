package com.example.tobi.springtobi.ch05.ex_5_1.service;

import com.example.tobi.springtobi.ch05.ex_5_1.dao.UserDao;

public class UserService_v1 {

    private UserDao userDao;

    public UserService_v1(UserDao userDao) {
        this.userDao = userDao;
    }
}
