package com.example.tobi.springtobi.ch05.ex_5_2.service;

import com.example.tobi.springtobi.ch05.ex_5_2.dao.DaoFactory;
import com.example.tobi.springtobi.ch05.ex_5_2.dao.UserDao;
import com.example.tobi.springtobi.ch05.ex_5_2.domain.Level;
import com.example.tobi.springtobi.ch05.ex_5_2.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DaoFactory.class)
class UserServiceTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PlatformTransactionManager transactionManager;

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

    @Test
    void upgradeAllOrNothing() {
        UserService testUserService = new UserService.TestUserService(users.get(3).getId());
        testUserService.setUserDao(userDao);

        for (User user : users) {
            userDao.add(user);
        }

        System.out.println(userDao.get("joytouch").getLevel());
        try {
            testUserService.upgradelevels();
        } catch (Exception e) {}
        System.out.println(userDao.get("joytouch").getLevel());

    }

    @Test
    void upgradeAllOrNothing_v2() {
        UserService testUserService = new UserService.TestUserService(users.get(3).getId());
        testUserService.setUserDao(userDao);
        testUserService.setDataSource(dataSource);

        for (User user : users) {
            userDao.add(user);
        }

        System.out.println(userDao.get("joytouch").getLevel());
        try {
            testUserService.upgradelevelsV2();
        } catch (Exception e) {}
        System.out.println(userDao.get("joytouch").getLevel());

    }

    @Test
    void upgradeAllOrNothing_v3() {
        UserService testUserService = new UserService.TestUserService(users.get(3).getId());
        testUserService.setUserDao(userDao);
        testUserService.setDataSource(dataSource);

        for (User user : users) {
            userDao.add(user);
        }

        System.out.println(userDao.get("joytouch").getLevel());
        try {
            testUserService.upgradelevelsV3();
        } catch (Exception e) {}
        System.out.println(userDao.get("joytouch").getLevel());

    }

    @Test
    void upgradeAllOrNothing_v4() {
        UserService testUserService = new UserService.TestUserService(users.get(3).getId());
        testUserService.setUserDao(userDao);
        testUserService.setDataSource(dataSource);
        testUserService.setTransactionManager(transactionManager);

        for (User user : users) {
            userDao.add(user);
        }

        System.out.println(userDao.get("joytouch").getLevel());
        try {
            testUserService.upgradelevelsV4();
        } catch (Exception e) {}
        System.out.println(userDao.get("joytouch").getLevel());

    }


    private void checkLevel(User user, Level expectedLevel) {
        User userUpdate = userDao.get(user.getId());
        Assertions.assertThat(userUpdate.getLevel()).isEqualTo(expectedLevel);
    }

}