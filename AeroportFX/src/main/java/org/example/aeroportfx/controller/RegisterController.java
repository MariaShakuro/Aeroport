package org.example.aeroportfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private TextField fromField;

    @FXML
    private TextField toField;

    @FXML
    private TextField departureDateField;

    @FXML
    private TextField returnDateField;

    @FXML
    private TextField passengerCountField;

    @FXML
    private Label adultCountLabel;

    @FXML
    private Label childCountLabel;

    @FXML
    private Label infantCountLabel;

    @FXML
    private Button searchButton;

    @FXML
    private RadioButton economyClassRadio;

    @FXML
    private RadioButton businessClassRadio;

    @FXML
    private RadioButton firstClassRadio;

    @FXML
    private VBox profileMenu;
    @FXML
    private VBox menuPane;

    @FXML
    private VBox companyInfo;

    @FXML
    private Button menuButton;

    private int adultCount = 0;
    private int childCount = 0;
    private int infantCount = 0;
    @FXML
    private DatePicker datePickerLeft;
    @FXML
    private DatePicker datePickerRight;
    @FXML
    private Button calendarButton;
    @FXML
    public void showCalendar() {
        if (datePickerLeft != null && datePickerRight != null) {
            datePickerLeft.setVisible(!datePickerLeft.isVisible());
            datePickerRight.setVisible(!datePickerRight.isVisible());
        } else {
            System.out.println("DatePicker is not properly initialized.");
        }
    }

    private ToggleGroup toggleGroup;
    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        economyClassRadio.setToggleGroup(toggleGroup);
        businessClassRadio.setToggleGroup(toggleGroup);
        firstClassRadio.setToggleGroup(toggleGroup);

    }

    @FXML
    private void increaseAdultCount() {
        adultCount++;
        adultCountLabel.setText(String.valueOf(adultCount));
    }

    @FXML
    private void decreaseAdultCount() {
        if (adultCount > 0) {
            adultCount--;
            adultCountLabel.setText(String.valueOf(adultCount));
        }
    }

    @FXML
    private void increaseChildCount() {
        childCount++;
        childCountLabel.setText(String.valueOf(childCount));
    }

    @FXML
    private void decreaseChildCount() {
        if (childCount > 0) {
            childCount--;
            childCountLabel.setText(String.valueOf(childCount));
        }
    }

    @FXML
    private void increaseInfantCount() {
        infantCount++;
        infantCountLabel.setText(String.valueOf(infantCount));
    }

    @FXML
    private void decreaseInfantCount() {
        if (infantCount > 0) {
            infantCount--;
            infantCountLabel.setText(String.valueOf(infantCount));
        }
    }

    @FXML
    private void searchButtonAction(ActionEvent event) throws IOException {
        navigateToPage(event, "/org/example/aeroportfx/Tickets.fxml");
    }

    @FXML
    public void toggleProfileMenu() {
        profileMenu.setVisible(!profileMenu.isVisible());
    }

    @FXML
    private void register(ActionEvent event) throws IOException {
        navigateToPage(event, "/org/example/aeroportfx/RegisterPage.fxml");
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        navigateToPage(event, "/org/example/aeroportfx/LoginPage.fxml");
    }

    @FXML
    private void showArrivals() {
        System.out.println("Showing arrivals");
    }

    @FXML
    private void switchLanguage() {
        // Логика переключения языка
        System.out.println("Switching language");
    }

    @FXML
    private void toggleMenu() {
        boolean isVisible = menuPane.isVisible();
        menuPane.setVisible(!isVisible);
        menuButton.setText(isVisible ? "Меню" : "Закрыть меню");
    }

    @FXML
    private void buyTicket(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/aeroportfx/view/Register.fxml"));
            Parent registerPage = loader.load();
            Scene registerScene = new Scene(registerPage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(registerScene);
            appStage.setFullScreen(true);
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/aeroportfx/view/Main.fxml"));
            Parent homePage = loader.load();
            Scene homeScene = new Scene(homePage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(homeScene);
            appStage.setFullScreen(true);
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showServices() {
        System.out.println("Showing services...");
    }

    @FXML
    private void toggleCompanyInfo() {
        boolean isVisible = companyInfo.isVisible();
        companyInfo.setVisible(!isVisible);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code if needed
    }

    private void navigateToPage(ActionEvent event, String fxmlFile) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(fxmlFile)));
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
