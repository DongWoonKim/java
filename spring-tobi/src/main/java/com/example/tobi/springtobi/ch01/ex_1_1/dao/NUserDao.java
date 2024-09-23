package com.example.tobi.springtobi.ch01.ex_1_1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String URL = "jdbc:mysql://localhost:3306/spring_tobi_2"; // 데이터베이스 URL
        String USER = "root"; // 데이터베이스 사용자 이름
        String PASSWORD = "1234"; // 데이터베이스 비밀번호

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
