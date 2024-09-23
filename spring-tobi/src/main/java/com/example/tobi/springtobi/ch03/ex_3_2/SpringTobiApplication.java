package com.example.tobi.springtobi.ch03.ex_3_2;

import com.example.tobi.springtobi.ch03.ex_3_2.dao.DaoFactory;
import com.example.tobi.springtobi.ch03.ex_3_2.dao.UserDao_v2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class SpringTobiApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setCharacter();

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao_v2 userDao = context.getBean("userDao", UserDao_v2.class);

        int count = userDao.getCount();
        System.out.println(count);

        userDao.deleteAll();

        count = userDao.getCount();
        System.out.println(count);


    }

    private static void setCharacter() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
