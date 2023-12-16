package com.example.musicrecommendation;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;

public class SongListCellFactory extends ListCell<Song> {

    private User user;
    @Override
    protected void updateItem(Song song, boolean empty) {
        super.updateItem(song, empty);

        if (empty || song == null) {
            setText(null);
            setGraphic(null);
        } else {

            setText(song.getTitle() + " - " + song.getGenre());


            Button addToPlaylistButton = new Button("Add to Playlist");
            addToPlaylistButton.setOnAction(event -> addToPlaylist(song));
            setGraphic(addToPlaylistButton);
        }
    }

    private void addToPlaylist(Song song) {

        MainPageDAO.addToPlaylist(user.getId(), song.getId());

    }
}
