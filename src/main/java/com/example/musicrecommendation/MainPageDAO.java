package com.example.musicrecommendation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainPageDAO {
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/project";
    private String username = "postgres";
    private String pass = "21442139";

    public MainPageDAO() {
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
            throw new RuntimeException(e);
        }
    }

    public void playlistsShow(List<Label> pTitleList) {
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select title from playlist");
            int index = 0;
            while (resultSet.next() && index < pTitleList.size()) {
                String title = resultSet.getString("title");
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
                "JOIN author a ON s.a_id = a.id " +
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
            PreparedStatement statement = connection.prepareStatement(
                    "select s.id as s_id, s.title as s_title, p.title as p_title from songs s " +
                    "full join song_playlist sp on s.id = sp.s_id " +
                    "full join playlist p on sp.p_id = p.id " +
                    "where p.title = ? ");

            statement.setString(1, p_title);
            ResultSet resultSet = statement.executeQuery();
            int index = 0;
            while (resultSet.next() && index < sTitleList.size()) {
                String title = resultSet.getString("s_title");
                sTitleList.get(index).setText(title);
                index++;
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void popularSongsShow(List<Label> sTitleList) {
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from songs order by popularity desc");
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

    public void newSongsShow(List<Label> sTitleList) {
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from songs s order by year desc");
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

    public void oldSongsShow(List<Label> sTitleList) {
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from songs s order by year asc");
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

    public List<String> songGenre() {
        List<String> genres = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url, username, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select distinct genre from songs;");
            while (resultSet.next()) {
                String genre = resultSet.getString("genre");
                genres.add(genre);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    public void songsByGenre(List<Label> sTitleList, String genre) {
        try {
            connection = DriverManager.getConnection(url, username, pass);
            PreparedStatement statement = connection.prepareStatement("select * from songs where genre = ?");
            statement.setString(1, genre);
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
