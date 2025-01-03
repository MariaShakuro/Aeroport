package org.example.aeroportfx.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TicketsController implements Initializable {

    @FXML
    private ListView<VBox> ticketListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ticketListView.setItems(FXCollections.observableArrayList());
        ticketListView.getItems().add(new VBox());
    }

    // Method to create a ticket item
    private VBox createTicketItem() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-border-color: grey; -fx-border-radius: 20; -fx-border-width: 1;");
        vbox.setPrefHeight(150);
        vbox.setPrefWidth(700);

        HBox hbox = new HBox();
        hbox.setSpacing(10);

        VBox leftVBox = new VBox();
        leftVBox.setSpacing(5);
        Label priceLabel = new Label("Цена");
        TextField priceField = new TextField();
        HBox baggageHBox = new HBox();
        baggageHBox.setSpacing(5);
        Label baggageLabel = new Label("Багаж");
        baggageLabel.setStyle("-fx-border-color: grey; -fx-border-radius: 10; -fx-padding: 5;");
        CheckBox baggageCheckBox = new CheckBox();
        baggageHBox.getChildren().addAll(baggageLabel, baggageCheckBox);

        leftVBox.getChildren().addAll(priceLabel, priceField, baggageHBox);

        Pane flightInfoPane = new Pane();
        flightInfoPane.setPrefHeight(100);

        hbox.getChildren().addAll(leftVBox, flightInfoPane);

        Button selectButton = new Button("Выбрать билет");
        selectButton.setStyle("-fx-background-color: purple; -fx-background-radius: 20; -fx-text-fill: white;");
        selectButton.setOnAction(event -> {
            try {
                navigateToBooking(event);
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception here or show an error message to the user
            }
        });

        vbox.getChildren().addAll(hbox, selectButton);

        return vbox;
    }

    // Method to navigate to the booking page
    @FXML
    private void navigateToBooking(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/aeroportfx/view/BookingTicket.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
