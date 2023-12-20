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

    @FXML
    private void addToPlaylistClicked() {
        if (song != null) {
            PlaylistModel.getInstance().addToPlaylist(song);
        }
    }







}



