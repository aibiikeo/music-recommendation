package com.example.musicrecommendation;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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

    MainPageDAO mainPageDAO = new MainPageDAO();

    public void playlistsShow() {
        String title = mainPageDAO.playlistsShow();
        pTitle.setText(title);
    }


}
