package com.example.musicrecommendation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PlaylistModel {

    private static PlaylistModel instance;
    private ObservableList<Song> playlist;

    private PlaylistModel() {
        playlist = FXCollections.observableArrayList();
    }

    public static synchronized PlaylistModel getInstance() {
        if (instance == null) {
            instance = new PlaylistModel();
        }
        return instance;
    }

    public ObservableList<Song> getPlaylist() {
        return playlist;
    }

    public void addToPlaylist(Song song) {
        playlist.add(song);
    }
    public void removeFromPlaylist(Song song) {
        playlist.remove(song);
    }

}
