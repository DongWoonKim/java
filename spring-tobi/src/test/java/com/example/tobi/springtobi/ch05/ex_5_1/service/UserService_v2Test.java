package com.example.tobi.springtobi.ch05.ex_5_1.service;

import com.example.tobi.springtobi.ch05.ex_5_1.dao.DaoFactory;
import com.example.tobi.springtobi.ch05.ex_5_1.dao.UserDao;
import com.example.tobi.springtobi.ch05.ex_5_1.domain.Level;
import com.example.tobi.springtobi.ch05.ex_5_1.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DaoFactory.class)
class UserService_v2Test {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService_v2 userService;
    List<User> users;

    @BeforeEach
    public void setUp() {
        userDao.deleteAll();
        users = Arrays.asList(
                new User("bumjin", "박범진", "p1", Level.BASIC, 49, 0),
                new User("joytouch", "강명성", "p2", Level.BASIC, 50, 0),
                new User("erwins", "신승한", "p3", Level.SILVER, 60, 29),
                new User("madnite1", "이상호", "p4", Level.SILVER, 60, 30),
                new User("green", "오민규", "p5", Level.GOLD, 100, 100)
        );
    }

    @Test
    public void upgradeLevels_메서드_테스트() {
        // given
        for (User user : users) {
            userDao.add(user);
        }

        // when
        userService.upgradelevels();

        // then
        checkLevel(users.get(0), Level.BASIC);
        checkLevel(users.get(1), Level.SILVER);
        checkLevel(users.get(2), Level.SILVER);
        checkLevel(users.get(3), Level.GOLD);
        checkLevel(users.get(4), Level.GOLD);

    }

    private void checkLevel(User user, Level expectedLevel) {
        User userUpdate = userDao.get(user.getId());
        Assertions.assertThat(userUpdate.getLevel()).isEqualTo(expectedLevel);
    }

}