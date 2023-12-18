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


    public void addToPlaylist(User user, Song song) throws SQLException {
        System.out.println("Adding song to playlist. User ID: " + user.getId() + ", Song ID: " + song.getId());

        String query = "INSERT INTO user_playlist (u_id, s_id) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,  user.getId());
            preparedStatement.setInt(2,  song.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding song to the playlist", e);
        }
    }


//    public List<Song> getUserPlaylist(User user) {
//        List<Song> userPlaylist = new ArrayList<>();
//        try {
//            connection = DriverManager.getConnection(url, username, pass);
//            String query = "SELECT s.* FROM user_playlist up " +
//                    "JOIN songs s ON up.s_id = s.id " +
//                    "WHERE up.u_id = ?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setInt(1, user.getId());
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    Song song = new Song();
//                    // Populate the song details from the result set
//                    userPlaylist.add(song);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userPlaylist;
//    }




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
