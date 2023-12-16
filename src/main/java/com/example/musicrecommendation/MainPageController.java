package com.example.musicrecommendation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class MainPageController {
    @FXML
    private Label sTitle;

    @FXML
    private ImageView sImg;

    @FXML
    private Label pTitle;

    @FXML
    private ImageView pImg;

    @FXML
    private Label popularSongs;

    @FXML
    private Label newSongs;

    @FXML
    private Label oldSongs;

    @FXML
    private ComboBox<String> songGenre;

    @FXML
    private ComboBox<String> box;

    MainPageDAO mainPageDAO = new MainPageDAO();

    public void playlistsShow() {
        String title = mainPageDAO.playlistsShow();
        pTitle.setText(title);
    }

    @FXML
    private void searchButtonClicked() {
        try {
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "21442139")) {

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

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }



    @FXML
    private void comboBoxSelected() {
        SelectionModel<String> selectionModel = box.getSelectionModel();
        String selectedItem = selectionModel.getSelectedItem();

        if (selectedItem != null && !selectedItem.isEmpty()){
            // Open the SongInformation.fxml when an item is selected
            openSongInformationWindow(selectedItem);
        }
    }

    private void openSongInformationWindow(String songTitle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("musicinfo.fxml"));
            Parent root = loader.load();

            // Pass the song title to the controller of the new window
            SongInformationController songInformationController = loader.getController();
            Song song = mainPageDAO.getSongByTitle(songTitle); // Assuming you have a method to get a Song by title
            songInformationController.setSong(song);

            // Create a new stage for the song information window
            Stage stage = new Stage();
            stage.setTitle("Song Information");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
