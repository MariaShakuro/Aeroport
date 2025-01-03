package org.example.aeroportfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginPageController {

    @FXML
    private TextField surnameField;

    @FXML
    private TextField passwordField;

    // Initialize method to set up any necessary bindings or default values
    @FXML
    public void initialize() {
        // Optionally add any initialization code here
    }

    // Method to handle login logic
    @FXML
    private void handleLogin() {
        String surname = surnameField.getText();
        String password = passwordField.getText();

        // Add your login logic here (e.g., validation, authentication, etc.)
        System.out.println("Logging in user with surname: " + surname);
    }
    @FXML
    private void navigateToRegister(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/aeroportfx/Register.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
