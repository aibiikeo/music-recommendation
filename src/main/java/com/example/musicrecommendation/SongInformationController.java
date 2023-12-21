package com.example.musicrecommendation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SongInformationController {
    @FXML
    private Label titleLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private Label popularityLabel;

    @FXML
    private Label authorNameLabel;

    private Song song;

    public void setSong(Song song) {
        this.song = song;
        updateLabels();
    }

    private void updateLabels() {
        if (song != null) {
            titleLabel.setText(song.getTitle());
            authorNameLabel.setText(song.getAuthorName());
            genreLabel.setText(song.getGenre());
            yearLabel.setText(String.valueOf(song.getYear()));
            popularityLabel.setText(String.valueOf(song.getPopularity()));
        }
    }

    private MainPageController mainPageController;

    public void setMainPageController(MainPageController mainPageController) {
        this.mainPageController = mainPageController;
    }

    MainPageDAO mainPageDAO = new MainPageDAO();
    @FXML
    private void addToPlaylistClicked() {
        if (song != null && mainPageController != null) {
            String s = String.valueOf(song);
            String title = s.substring(0, s.indexOf("-")-1);
            String name = s.substring(s.indexOf("-")+2);
            mainPageDAO.addUserSong(title, name);
            PlaylistModel.getInstance().addToPlaylist(song);
            mainPageController.updatePlaylistListView();
        }
    }


}



