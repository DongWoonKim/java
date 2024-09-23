package com.example.tobi.springtobi.ch01.ex_1_1.dao;

import com.example.tobi.springtobi.ch01.ex_1_1.domain.User;

import java.sql.*;

public abstract class UserDao {

//    private Connection getConnection() throws SQLException, ClassNotFoundException {
//        String URL = "jdbc:mysql://localhost:3306/spring_tobi"; // 데이터베이스 URL
//        String USER = "root"; // 데이터베이스 사용자 이름
//        String PASSWORD = "1234"; // 데이터베이스 비밀번호
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
    public abstract Connection getConnection() throws SQLException, ClassNotFoundException;

    public void add(User user) throws ClassNotFoundException, SQLException {

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into user(id, name, password) values(?,?,?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE id = ?");

        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();

        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        conn.close();

        return user;
    }

}
