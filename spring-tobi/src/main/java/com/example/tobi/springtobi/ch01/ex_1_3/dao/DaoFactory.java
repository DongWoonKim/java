package com.example.tobi.springtobi.ch01.ex_1_3.dao;

public class DaoFactory {

    public UserDao userDao() {
        return new UserDao(getConnection());
    }

    public AccountDao accountDao() {
        return new AccountDao(getConnection());
    }

    public MessageDao messageDao() {
        return new MessageDao(getConnection());
    }

    public ConnectionMaker getConnection() {
        return new DConnectionMaker();
    }

}
