package com.example.tobi.springtobi.ch05.ex_5_1.service;

import com.example.tobi.springtobi.ch05.ex_5_1.dao.UserDao;
import com.example.tobi.springtobi.ch05.ex_5_1.domain.Level;
import com.example.tobi.springtobi.ch05.ex_5_1.domain.User;

import java.util.List;

public class UserService_v1 {

    private UserDao userDao;

    public UserService_v1(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        if (user.getLevel() == null) {
            user.setLevel(Level.BASIC);
        }
        userDao.add(user);
    }

    public void upgradelevels() {
        List<User> users = userDao.getAll();

        for (User user : users) {
            Boolean changed = null;

            if (
                    user.getLevel() == Level.BASIC &&
                    user.getLogin() >= 50
            ) {
                user.setLevel(Level.SILVER);
                changed = true;
            }
            else if (
                user.getLevel() == Level.SILVER &&
                user.getRecommend() >= 30
            ) {
                user.setLevel(Level.GOLD);
                changed = true;
            }
            else if ( user.getLevel() == Level.GOLD ) {
                changed = false;
            }
            else {
                changed = false;
            }

            if (changed) {
                userDao.update(user);
            }

        }

    }

}
