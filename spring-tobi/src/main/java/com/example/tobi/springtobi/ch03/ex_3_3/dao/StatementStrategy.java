package com.example.tobi.springtobi.ch03.ex_3_3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {
    PreparedStatement makePreparedStatement(Connection connection) throws SQLException;
}
