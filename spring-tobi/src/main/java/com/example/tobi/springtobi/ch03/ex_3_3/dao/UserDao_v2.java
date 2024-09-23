package com.example.tobi.springtobi.ch03.ex_3_3.dao;

import com.example.tobi.springtobi.ch03.ex_3_3.domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao_v2 {

    private DataSource dataSource;

    public UserDao_v2(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        class AddStatement implements StatementStrategy {
            @Override
            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("insert into user(id, name, password) values(?,?,?)");

                ps.setString(1, user.getId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword());
                ps.executeUpdate();

                return ps;
            }
        }

        StatementStrategy strategy = new AddStatement();
        jdbcContextWithStatementStrategy(strategy);
    }

    public void deleteAll() throws SQLException {
        class DeleteAllStatement implements StatementStrategy {
            @Override
            public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps;
                ps = connection.prepareStatement("delete from user");

                return ps;
            }
        }

        StatementStrategy strategy = new DeleteAllStatement();
        jdbcContextWithStatementStrategy(strategy);
    }

    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection conn = dataSource.getConnection();
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

    public int getCount() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement("select count(*) from user");
            rs = ps.executeQuery();
            rs.next();

            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void jdbcContextWithStatementStrategy(StatementStrategy strategy) throws SQLException {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = dataSource.getConnection();
            ps = strategy.makePreparedStatement(connection);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                ps.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

}
