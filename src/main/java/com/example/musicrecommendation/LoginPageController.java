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
    private TextField inputLogin;
    @FXML
    private PasswordField inputPassword;
    private Stage stage;
    private Scene scene;
    LoginPageDAO loginPageDAO = new LoginPageDAO();

    public void initialize() {
        loginPageDAO.loggedFalse();
    }

    private void alert(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(error);
        alert.showAndWait();
    }

    public void loginbutton(ActionEvent event) {
        LogInPage logInPage = new LogInPage();
        logInPage.setLogin(inputLogin.getText());
        logInPage.setPassword(inputPassword.getText());
        try {
            if (loginPageDAO.isPasswordInDatabase(logInPage.getLogin(), logInPage.getPassword())) {
                loginPageDAO.loggedTrue(logInPage.getLogin(), logInPage.getPassword());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
                Parent root = loader.load();
                MainPageController mainPageController = loader.getController();
                mainPageController.show();
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

    public void signInButton(){
        LogInPage logInPage = new LogInPage();
        logInPage.setLogin(inputLogin.getText());
        logInPage.setPassword(inputPassword.getText());
        try {
            if (!loginPageDAO.isPasswordInDatabase(logInPage.getLogin(), logInPage.getPassword())) {
                loginPageDAO.addtodatabase(logInPage.getLogin(), logInPage.getPassword());
                alert("You created an account! Success!");
            } else {
                alert("Can't make registration. Or you already have it.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}