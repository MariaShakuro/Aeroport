package org.example.aeroportfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class RegisterPageController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    // Initialize method to set up any necessary bindings or default values
    @FXML
    public void initialize() {
        // Optionally add any initialization code here
    }

    // Method to handle registration logic
    @FXML
    private void handleRegister() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        // Add your registration logic here (e.g., validation, storing user data, etc.)
        System.out.println("Registering user: " + name + " " + surname + " with email: " + email);
    }

    // Method to navigate back to the main register page
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
