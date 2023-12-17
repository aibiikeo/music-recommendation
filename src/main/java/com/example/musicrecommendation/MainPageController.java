package com.example.musicrecommendation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.SelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

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
    private Label logoutButton;

    @FXML
    private ComboBox<String> box;
    @FXML
    private Label playlistTitle;

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

    @FXML
    private void logoutButtonClicked() {
        openLoginWindow();
    }

    private void openLoginWindow() {
        try {
            Stage primaryStage = (Stage) logoutButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Label findLabelInAnchorPane(AnchorPane anchorPane) {
        for (Node node : anchorPane.getChildren()) {
            if (node instanceof Label) {
                return (Label) node;
            }
        }
        return null;
    }

    private Label getLabelPane (Pane pane) {
        Node node = findLabelInAnchorPane((AnchorPane) pane.getParent());
        if (node instanceof Label) {
            return (Label) node;
        }
        return null;
    }

    @FXML
    public void openSongInfo(MouseEvent event) {
        if (event.getTarget() instanceof AnchorPane) {
            AnchorPane clickedAnchorPane = (AnchorPane) event.getTarget();
            Label songLabel = findLabelInAnchorPane(clickedAnchorPane);
            if (songLabel != null) {
                String songTitle = songLabel.getText();
                openSongInformationWindow(songTitle);
            }
        }
        else if(event.getTarget() instanceof Pane){
            Pane clickedPane = (Pane) event.getTarget();
            Label songLabel = getLabelPane(clickedPane);
            if (songLabel != null) {
                String songTitle = songLabel.getText();
                openSongInformationWindow(songTitle);
            }
        }
        else if(event.getTarget() instanceof Label){
            Label clickedLabel = (Label) event.getTarget();
            if (clickedLabel != null) {
                String songTitle = clickedLabel.getText();
                openSongInformationWindow(songTitle);
            }
        }
        else if(event.getTarget() instanceof Text){
            Text clickedText = (Text) event.getTarget();
            openSongInformationWindow(String.valueOf(clickedText));
        }
    }

    @FXML
    public void openPlaylist(MouseEvent event) {
        System.out.println(event.getTarget());
        if (event.getTarget() instanceof AnchorPane) {
            AnchorPane clickedAnchorPane = (AnchorPane) event.getTarget();
            Label songLabel = findLabelInAnchorPane(clickedAnchorPane);
            if (songLabel != null) {
                String songTitle = songLabel.getText();
                mainPageDAO.playlistSongsShow(sTitleList, songTitle);
                playlistTitle.setText(songTitle);
            }
        }
        else if(event.getTarget() instanceof Pane){
            Pane clickedPane = (Pane) event.getTarget();
            Label songLabel = getLabelPane(clickedPane);
            if (songLabel != null) {
                String songTitle = songLabel.getText();
                mainPageDAO.playlistSongsShow(sTitleList, songTitle);
                playlistTitle.setText(songTitle);
            }
        }
        else if(event.getTarget() instanceof Label){
            Label clickedLabel = (Label) event.getTarget();
            if (clickedLabel != null) {
                String songTitle = clickedLabel.getText();
                mainPageDAO.playlistSongsShow(sTitleList, songTitle);
                playlistTitle.setText(songTitle);
            }
        }
        else if(event.getTarget() instanceof Text){
            Text clickedText = (Text) event.getTarget();
            mainPageDAO.playlistSongsShow(sTitleList, String.valueOf(clickedText));
            playlistTitle.setText(String.valueOf(clickedText));
        }
    }
}
