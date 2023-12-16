package com.example.musicrecommendation;


import java.sql.*;


public class LoginPageDAO {
    private Connection conn;
    private String url = "jdbc:postgresql://localhost:5432/music-recommedation";
    private String username = "postgres";
    private String pass = "123456";
    LogInPage logInPage = new LogInPage();

    public LoginPageDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/music-recommedation";
            conn = DriverManager.getConnection(url, username, pass);
            conn.setAutoCommit(false);

            // Test the connection
            if (conn.isValid(1)) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Print the full stack trace
            System.err.println("Error executing query: " + e.getMessage());
            throw new RuntimeException("Error checking password in the database", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error closing the database connection", e);
        }
    }

    public boolean isPasswordInDatabase(String login, String password) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM \"public\".user_info WHERE login = ? AND password = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
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
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, password);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Record inserted successfully.");

                // Commit the changes
                conn.commit();
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            throw new RuntimeException("Error inserting data into the database", e);
        }
        return false;
    }
}