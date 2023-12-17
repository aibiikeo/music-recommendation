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
    private User currentUser;
    LoginPageDAO loginPageDAO = new LoginPageDAO();

    private void alert(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(error);
        alert.showAndWait();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    @FXML
    public void loginbutton(ActionEvent event) {
        LogInPage logInPage = new LogInPage();
        logInPage.setLogin(inputEmail.getText());
        logInPage.setPassword(inputPassword.getText());
        try {
            if (loginPageDAO.isPasswordInDatabase(logInPage.getLogin(), logInPage.getPassword())) {
                currentUser = new User(logInPage.getLogin());

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));

                try {
                    Parent root = loader.load();
                    MainPageController mainPageController = loader.getController();
                    mainPageController.setCurrentUser(currentUser);  // Pass the current user to MainPageController

                    // Debugging: Print a message to confirm that the code reached this point
                    System.out.println("Main.fxml loaded successfully.");


                    Stage newStage = new Stage();
                    newStage.setScene(new Scene(root));
                    newStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                    alert("Error loading Main.fxml: " + e.getMessage());
                }

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
            alert("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void signInButton(ActionEvent event) {
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
            alert("An unexpected error occurred: " + e.getMessage());
        }
    }
}
