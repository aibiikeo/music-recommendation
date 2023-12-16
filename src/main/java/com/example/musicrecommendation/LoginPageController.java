package com.example.musicrecommendation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginPageController {
    @FXML
    private TextField inputEmail;
    @FXML
    private PasswordField inputPassword;
    private Stage stage;
    private Scene scene;
    LoginPageDAO loginPageDAO = new LoginPageDAO();

    private void alert(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(error);
        alert.showAndWait();
    }

    public void loginbutton(ActionEvent event) throws IOException {
        LogInPage logInPage = new LogInPage();
        logInPage.setLogin(inputEmail.getText());
        logInPage.setPassword(inputPassword.getText());
        try {
            if (loginPageDAO.isPasswordInDatabase(logInPage.getLogin(), logInPage.getPassword())) {
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(root);
                scene = new Scene(scrollPane);
                scrollPane.setFitToWidth(true);
                scrollPane.setFitToHeight(true);
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
        logInPage.setLogin(inputEmail.getText());
        logInPage.setPassword(inputPassword.getText());
        try {
            if (!loginPageDAO.isPasswordInDatabase(logInPage.getLogin(), logInPage.getPassword())) {
                loginPageDAO.addtodatabase(logInPage.getLogin(), logInPage.getPassword());
                alert("You created an account! Success!");
            } else {
                alert("You don't have an account.\nOr error in entering email and password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    logout

}