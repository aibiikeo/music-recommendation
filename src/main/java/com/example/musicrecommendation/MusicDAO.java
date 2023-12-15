package com.example.musicrecommendation;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class MusicDAO {
    private Connection conn;
    private String url = "jdbc:postgresql://localhost:5432/project";
    private String username = "postgres";
    private String pass = "21442139";
    LogInPage logInPage = new LogInPage();

    private static DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, pass);
    }

    public MusicDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/project";
            conn = DriverManager.getConnection(url, username, pass);
            conn.setAutoCommit(true);

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

    public boolean isPasswordInDatabase(String email, String password) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM \"public\".user_info WHERE login = ? AND password = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, email);
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

    public boolean addtodatabase(String email, String password) throws SQLException {
        String sql = "INSERT INTO \"public\".user_info (login, password) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, email);
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

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM songs";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Song song = new Song();
                        song.setId(resultSet.getInt("id"));
                        song.setTitle(resultSet.getString("title"));
                        song.setGenre(resultSet.getString("genre"));


                        songs.add(song);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return songs;
    }

    public static void addToPlaylist(int userId, int songId) {
        String addToPlaylistQuery = "INSERT INTO user_playlist (u_id, s_id) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addToPlaylistQuery)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, songId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}