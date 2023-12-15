package com.example.musicrecommendation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private Stage stage;
    private Scene scene;
    private Parent root;
    MusicDAO musicDAO = new MusicDAO();


//    public void onButtonLogIn(ActionEvent event) throws IOException  {
//        LogInPage logInPage = new LogInPage();
//        logInPage.setEmail(inputEmail.getText());
//        logInPage.setPassword(inputPassword.getText());
//
//        try {
//            if (musicDAO.isEmailInDatabase(logInPage.getEmail()) && musicDAO.isPasswordInDatabase(logInPage.getPassword())) {
//                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
//                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//            }
//        } catch (Exception e) {
//            // Catching any exceptions that might occur during database operations
//            e.printStackTrace();
//        }
//    }




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
                alert("You don't have an account.\nOr error in entering email and password");
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
                alert("You created an account! Success! Now log in please");

            } else {
                alert("Error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
