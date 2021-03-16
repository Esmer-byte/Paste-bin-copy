package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.example.demo.user;
public class Insert {

    private final String url = "******";
    private final String user = "******";
    private final String password = "*******";


    public void insertValues(user User) throws SQLException {
             Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement(); {
             statement.executeUpdate("INSERT INTO user_roles (username, role) VALUES ('"+User.getUserName()+"', 'ROLE_USER');");
             System.out.println("Created with success!");
            }

    }
}