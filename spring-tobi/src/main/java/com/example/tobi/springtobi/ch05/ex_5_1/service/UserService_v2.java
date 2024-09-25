package com.example.tobi.springtobi.ch05.ex_5_1.service;

import com.example.tobi.springtobi.ch05.ex_5_1.dao.UserDao;
import com.example.tobi.springtobi.ch05.ex_5_1.domain.Level;
import com.example.tobi.springtobi.ch05.ex_5_1.domain.User;

import java.util.List;

public class UserService_v2 {

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECCOMMEND_FOR_GOLD = 30;

    private UserDao userDao;

    public UserService_v2(UserDao userDao) {
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
            if ( canUpgradeLevel(user) ) {
                // upgrade
                upgradeLevel(user);
            }
        }
    }

    private boolean canUpgradeLevel(User user) {
        Level currentLevel = user.getLevel();

        switch (currentLevel) {
            case BASIC:
                return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER:
                return (user.getRecommend() >= MIN_RECCOMMEND_FOR_GOLD);
            case GOLD:
                return false;
            default:
                throw new IllegalStateException("Unexpected value: " + currentLevel);
        }
    }

    private void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
    }

}
