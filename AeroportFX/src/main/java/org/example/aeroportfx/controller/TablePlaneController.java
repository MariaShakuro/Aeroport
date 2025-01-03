package org.example.aeroportfx.controller;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


public class TablePlaneController {
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Label arrivalLabel;

    @FXML
    private TableView flightTable;

    @FXML
    private TableColumn flightNumberColumn;

    @FXML
    private TableColumn destinationColumn;

    @FXML
    private TableColumn statusColumn;

    @FXML
    private TableColumn timeColumn;

    @FXML
    private VBox menuPane;

    @FXML
    private VBox companyInfo;

    @FXML
    private Button menuButton;

    @FXML
    private void initialize() {
        flightTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        flightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/aeroportfx/Register.fxml"));
            Parent registerPage = loader.load();
            Scene registerScene = new Scene(registerPage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(registerScene);
            appStage.setFullScreen(true);
            appStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/aeroportfx/Main.fxml"));
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

}
