package com.example.musicrecommendation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.SelectionModel;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class MainPageController {
    @FXML
    private Label sTitle1;
    @FXML
    private Label sTitle2;
    @FXML
    private Label sTitle3;
    @FXML
    private Label sTitle4;
    @FXML
    private Label sTitle5;
    @FXML
    private Label sTitle6;
    @FXML
    private Label sTitle7;
    @FXML
    private Label sTitle8;
    @FXML
    private Label sTitle9;
    @FXML
    private Label sTitle10;
    @FXML
    private Label sTitle11;
    @FXML
    private Label sTitle12;
    @FXML
    private Label sTitle13;
    @FXML
    private Label sTitle14;
    @FXML
    private Label sTitle15;
    @FXML
    private Label pTitle1;
    @FXML
    private Label pTitle2;
    @FXML
    private Label pTitle3;
    @FXML
    private Label pTitle4;
    @FXML
    private Label pTitle5;

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

    private List<Label> pTitleList;
    private List<Label> sTitleList;

    public void initialize() {
        pTitleList = new ArrayList<>();
        pTitleList.add(pTitle1);
        pTitleList.add(pTitle2);
        pTitleList.add(pTitle3);
        pTitleList.add(pTitle4);
        pTitleList.add(pTitle5);
        sTitleList = new ArrayList<>();
        sTitleList.add(sTitle1);
        sTitleList.add(sTitle2);
        sTitleList.add(sTitle3);
        sTitleList.add(sTitle4);
        sTitleList.add(sTitle5);
        sTitleList.add(sTitle6);
        sTitleList.add(sTitle7);
        sTitleList.add(sTitle8);
        sTitleList.add(sTitle9);
        sTitleList.add(sTitle10);
        sTitleList.add(sTitle11);
        sTitleList.add(sTitle12);
        sTitleList.add(sTitle13);
        sTitleList.add(sTitle14);
        sTitleList.add(sTitle15);
    }

    public void show() {
        mainPageDAO.playlistsShow(pTitleList);
        mainPageDAO.songsShow(sTitleList);
    }

    @FXML
    private void searchButtonClicked() {
        mainPageDAO.searchButton(box);
    }

    @FXML
    private void comboBoxSelected() {
        SelectionModel<String> selectionModel = box.getSelectionModel();
        String selectedItem = selectionModel.getSelectedItem();
        if (selectedItem != null && !selectedItem.isEmpty()){
            openSongInformationWindow(selectedItem);
        }
    }

    private void openSongInformationWindow(String songTitle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("musicinfo.fxml"));
            Parent root = loader.load();
            SongInformationController songInformationController = loader.getController();
            Song song = mainPageDAO.getSongByTitle(songTitle);
            songInformationController.setSong(song);
            Stage stage = new Stage();
            stage.setTitle("Song Information");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
