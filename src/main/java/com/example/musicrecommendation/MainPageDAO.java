package com.example.musicrecommendation;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainPageDAO {
    private Connection conn;
    private String url = "jdbc:postgresql://localhost:5432/project";
    private String username = "postgres";
    private String pass = "21442139";
    private static DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, pass);
    }

    public MainPageDAO() {
        try {
            Class.forName("org.postgresql.Driver");
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

    public String playlistsShow() {
        String title = "";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select distinct p_title from playlist");
            while (resultSet.next()) {
                title = resultSet.getString("p_title");
                System.out.println(title);
            }
            resultSet.close();
            statement.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return title;
    }


    public Song getSongByTitle(String title) {
        String sql = "SELECT s.*, a.name AS author_name " +
                "FROM songs s " +
                "JOIN author a ON s.author_id = a.id " +
                "WHERE s.title = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, title);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Song song = new Song();
                    song.setId(resultSet.getInt("id"));
                    song.setTitle(resultSet.getString("title"));
                    song.setGenre(resultSet.getString("genre"));
                    song.setYear(resultSet.getInt("year"));
                    song.setPopularity(resultSet.getInt("popularity"));
                    song.setAuthorName(resultSet.getString("author_name"));

                    return song;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
