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
            connection.setAutoCommit(false);

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
        String sql = "SELECT COUNT(*) AS count FROM \"public\".user_info WHERE login = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    System.out.println("Count from the database: " + count);
                    return count > 0;
                }
            } catch (SQLException e) {
                System.err.println("Error processing ResultSet: " + e.getMessage());
                throw new RuntimeException("Error checking password in the database", e);
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            throw new RuntimeException("Error checking password in the database", e);
        }
        return false;
    }

    public boolean addtodatabase(String login, String password) throws SQLException {
        String sql = "INSERT INTO \"public\".user_info (login, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, password);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Record inserted successfully.");
                connection.commit();
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            throw new RuntimeException("Error inserting data into the database", e);
        }
        return false;
    }

    public int getUserInfo(String login, String password){
        int id = 0;
        try {
            connection = DriverManager.getConnection(url, username, pass);
            PreparedStatement statement = connection.prepareStatement("select id from user_info where login =? and password=?;");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}