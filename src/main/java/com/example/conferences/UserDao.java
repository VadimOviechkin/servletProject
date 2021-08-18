package com.example.conferences;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public User registerUser(User user) throws ClassNotFoundException {
        PreparedStatement prep1;
        Connection connection = null;

        try {
            prep1 = connection.prepareStatement(SQL.ADD_USER.getQuery());
            prep1.setString(1, user.getUsername());
            prep1.setString(2, user.getEmail());
            prep1.setString(3, user.getPassword());

            prep1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
