package com.example.tobi.springtobi.ch01.ex_1_4.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDao(getConnection());
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDao(getConnection());
    }

    @Bean
    public MessageDao messageDao() {
        return new MessageDao(getConnection());
    }

    @Bean
    public ConnectionMaker getConnection() {
        return new DConnectionMaker();
    }

}
