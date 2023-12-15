package com.example.musicrecommendation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class controller {
    @FXML
    private Label author;
    @FXML
    private ImageView image;
    @FXML
    private Label name;
    @FXML
    private TextField inputEmail;
    @FXML
    private PasswordField inputPassword;
    private List<String> recommendations = new ArrayList<>();
    Randomblock randomblock = new Randomblock();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField searchField;
    MusicDAO musicDAO = new MusicDAO();

    @FXML
    private ListView<Song> songListView;



    public void initialize(URL location, ResourceBundle resources) {
        // Set the cell factory to display songs
        songListView.setCellFactory((Callback<ListView<Song>, ListCell<Song>>) new SongListCellFactory());
    }




    private void alert(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(error);
        alert.showAndWait();
    }
    public void loginbutton(ActionEvent event) throws IOException {
        LogInPage logInPage = new LogInPage();
        logInPage.setEmail(inputEmail.getText());
        logInPage.setPassword(inputPassword.getText());
        try {
            if (musicDAO.isPasswordInDatabase(logInPage.getEmail(), logInPage.getPassword())) {
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                alert("You don't have an account.\nOr error in entering login and password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void signInButton(ActionEvent event) throws IOException {
        LogInPage logInPage = new LogInPage();
        logInPage.setEmail(inputEmail.getText());
        logInPage.setPassword(inputPassword.getText());
        try {
            if (!musicDAO.isPasswordInDatabase(logInPage.getEmail(), logInPage.getPassword())) {
                musicDAO.addtodatabase(logInPage.getEmail(), logInPage.getPassword());
                alert("You created an account! Success!");

            } else {
                alert("You don't have an account.\nOr error in entering email and password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleSearch() {

        String searchTerm = searchField.getText();
        if (searchTerm != null && !searchTerm.isEmpty()) {
            // Perform the search query using the searchTerm
            MusicDAO musicDAO = new MusicDAO();

            try (Connection connection = musicDAO.getConnection()) {
                // Your database operations using the connection...
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }
    }

    private void loadSongs() {
        // Use your MusicDAO or another class to get a list of songs from the database
        List<Song> songs = musicDAO.getAllSongs();

        // Populate the ListView with songs
        songListView.getItems().addAll(songs);
    }
}