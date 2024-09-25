package com.example.tobi.springtobi.ch05.ex_5_2.dao;

import com.example.tobi.springtobi.ch05.ex_5_2.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDaoJdbc(dataSource());
    }

    @Bean
    public UserService userService() {
        return new UserService(userDao());
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_tobi");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        
        return dataSource;
    }

}
