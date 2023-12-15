package com.example.musicrecommendation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(application.class.getResource("loginPage.fxml"));
            Parent root = fxmlLoader.load();
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(root);
            Scene scene = new Scene(scrollPane);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            stage.setTitle("Music Recommendations!");
            stage.setScene(scene);
            stage.setMinWidth(800);
            stage.setMinHeight(500);
            stage.setMaxWidth(2000);
            stage.setMaxHeight(1000);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}