package com.example.tobi.springtobi.ch05.ex_5_1.dao;

import com.example.tobi.springtobi.ch05.ex_5_1.domain.Level;
import com.example.tobi.springtobi.ch05.ex_5_1.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJdbc {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> rowMapper;

    public UserDaoJdbc(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setLevel( Level.valueOf(rs.getInt("level")) );
                user.setLogin(rs.getInt("login"));
                user.setRecommend(rs.getInt("recommend"));

                return user;
            }
        };
    }

    public void add(User user) {
        this.jdbcTemplate.update(
            "insert into user(id, name, password, level, login, recommend) values(?,?,?,?,?,?)",
            user.getId(), user.getName(), user.getPassword(), user.getLevel(), user.getLogin(), user.getRecommend()
        );
    }

    public void deleteAll() {
        this.jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        return con.prepareStatement("delete from user");
                    }
                }
        );
    }

    public List<User> getAll() {
        return this.jdbcTemplate
                .query("select * from user", this.rowMapper);
    }

    public User get(String id){
        return this.jdbcTemplate.queryForObject(
                "select * from user where id = ?",
                new Object[]{id},
                this.rowMapper
        );
    }

    public int getCount() throws SQLException {
        return this.jdbcTemplate.queryForObject(
                "select count(*) from user",
                Integer.class
        );
    }

}
