package com.example.musicrecommendation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.sql.*;
import java.util.List;

public class MainPageDAO {
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/project";
    private String username = "postgres";
    private String pass = "21442139";

    public MainPageDAO() {
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

    public void playlistsShow(List<Label> pTitleList) {
        try {
            connection = DriverManager.getConnection(url, username, pass);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void songsShow(List<Label> sTitleList) {
        try {
            connection = DriverManager.getConnection(url, username, pass);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchButton(ComboBox<String> box) {
        try {
            connection = DriverManager.getConnection(url, username, pass);
            String searchQuery = "SELECT * FROM songs WHERE title LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
                String userInput = box.getEditor().getText();
                preparedStatement.setString(1, "%" + userInput + "%");
                ResultSet resultSet = preparedStatement.executeQuery();
                ObservableList<String> songTitles = FXCollections.observableArrayList();
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    songTitles.add(title);
                }
                box.setItems(songTitles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Song getSongByTitle(String title) {
        String sql = "SELECT s.*, a.name AS author_name " +
                "FROM songs s " +
                "JOIN author a ON s.author_id = a.id " +
                "WHERE s.title = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
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

    public void playlistSongsShow(List<Label> sTitleList, String p_title) {
        try {
            connection = DriverManager.getConnection(url, username, pass);
            PreparedStatement statement = connection.prepareStatement("select s.title from songs s natural join playlist p where s.id = p.s_id and p.p_title = ?");
            statement.setString(1, p_title);
            ResultSet resultSet = statement.executeQuery();
            int index = 0;
            while (resultSet.next() && index < sTitleList.size()) {
                String title = resultSet.getString("title");
                sTitleList.get(index).setText(title);
                index++;
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
