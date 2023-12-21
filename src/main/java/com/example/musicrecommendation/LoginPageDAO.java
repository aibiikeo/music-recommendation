package com.example.musicrecommendation;

import java.sql.*;

public class LoginPageDAO {
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/project";
    private String username = "postgres";
    private String pass = "21442139";

    public LoginPageDAO() {
        try {
            connection = DriverManager.getConnection(url, username, pass);
            if (connection.isValid(1)) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error executing query: " + e.getMessage());
            throw new RuntimeException("Error checking password in the database", e);
        }
    }

    public boolean isPasswordInDatabase(String login, String password) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM user_info WHERE login = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                System.out.println("Count from the database: " + count);
                return count > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            throw new RuntimeException("Error checking password in the database", e);
        }
        return false;
    }

    public void addtodatabase(String login, String password) throws SQLException {
        String sql = "INSERT INTO user_info (login, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, password);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Record inserted successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            throw new RuntimeException("Error inserting data into the database", e);
        }
    }

    public void loggedTrue(String login, String password){
        try {
            connection = DriverManager.getConnection(url, username, pass);
            PreparedStatement statement = connection.prepareStatement(
                    "update user_info " +
                    "set logged = true " +
                    "where login = ? and password = ? ");
            statement.setString(1, login);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loggedFalse(){
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement statement = connection.createStatement();
            statement.execute("update user_info set logged = false");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}