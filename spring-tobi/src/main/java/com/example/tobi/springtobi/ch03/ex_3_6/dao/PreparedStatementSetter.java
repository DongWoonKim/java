package com.example.tobi.springtobi.ch03.ex_3_6.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
    void setParmeters(PreparedStatement ps) throws SQLException;
}
