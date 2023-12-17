package com.example.musicrecommendation;

import javafx.scene.control.Label;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainPageDAO {
    private String url = "jdbc:postgresql://localhost:5432/music-recommedation";
    private String username = "postgres";
    private String pass = "123456";
    private static DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, pass);
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

    public void playlistsShow(List<Label> pTitleList) {
        try {
            Connection connection = DriverManager.getConnection(url, username, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select distinct p_title from playlist");
            int index = 0;
            while (resultSet.next() && index < pTitleList.size()) {
                String title = resultSet.getString("p_title");
                pTitleList.get(index).setText(title);
                index++;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void songsShow(List<Label> sTitleList) {
        try {
            Connection connection = DriverManager.getConnection(url, username, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select title from songs order by random()");
            int index = 0;
            while (resultSet.next() && index < sTitleList.size()) {
                String title = resultSet.getString("title");
                sTitleList.get(index).setText(title);
                index++;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
