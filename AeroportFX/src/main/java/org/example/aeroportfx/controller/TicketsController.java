package org.example.aeroportfx.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.aeroportfx.model.Flight;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TicketsController implements Initializable {

    @FXML
    private ListView<VBox> ticketListView;

    private List<Flight> flights = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ticketListView.setItems(FXCollections.observableArrayList());
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
        updateTicketListView();
    }

    private void updateTicketListView() {
        ticketListView.getItems().clear();

        if (flights.isEmpty()) {
            showNoResults();
        } else {
            Map<LocalDate, List<Flight>> flightsByDate = flights.stream()
                    .collect(Collectors.groupingBy(flight -> flight.getDepartureTime().toLocalDate()));

            for (Map.Entry<LocalDate, List<Flight>> entry : flightsByDate.entrySet()) {
                ticketListView.getItems().add(createTicketItem(entry.getValue()));
            }
        }
    }


    private VBox createTicketItem(List<Flight> flights) {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-border-color: grey; -fx-border-radius: 20; -fx-border-width: 1;");
        vbox.setPrefHeight(150);
        vbox.setPrefWidth(700);

        HBox hbox = new HBox();
        hbox.setSpacing(10);

        VBox leftVBox = new VBox();
        leftVBox.setSpacing(5);

        for (Flight flight : flights) {
            Label flightNumberLabel = new Label("Номер рейса: " + flight.getFlightNumber());
            Label fromToLabel = new Label("Откуда: " + flight.getCityOfRegistration() + " - Куда: " + flight.getCityOfDestination());
            Label departureTimeLabel = new Label("Время вылета: " + flight.getDepartureTime().toString()); // Полное время
            Label arrivalTimeLabel = new Label("Время прибытия: " + flight.getArrivalTime().toString()); // Полное время
            Label statusLabel = new Label("Статус: " + flight.getStatus());

            leftVBox.getChildren().addAll(flightNumberLabel, fromToLabel, departureTimeLabel, arrivalTimeLabel, statusLabel);
        }

        Pane flightInfoPane = new Pane();
        flightInfoPane.setPrefHeight(100);

        // Добавление разделительной линии, если количество записей больше одной
        if (flights.size() > 1) {
            VBox separator = new VBox();
            separator.setStyle("-fx-background-color: grey;");
            separator.setPrefWidth(5);
            hbox.getChildren().addAll(leftVBox, separator, flightInfoPane);
        } else {
            hbox.getChildren().addAll(leftVBox, flightInfoPane);
        }

        Button selectButton = new Button("Выбрать билет");
        selectButton.setStyle("-fx-background-color: purple; -fx-background-radius: 20; -fx-text-fill: white;");
        selectButton.setOnAction(event -> {
            try {
                navigateToBooking(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        vbox.getChildren().addAll(hbox, selectButton);

        return vbox;
    }


    public void showNoResults() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: lightgrey; -fx-background-radius: 20; -fx-border-color: grey; -fx-border-radius: 20; -fx-border-width: 1;");
        vbox.setPrefHeight(150);
        vbox.setPrefWidth(700);
        vbox.setAlignment(Pos.CENTER);

        Label noResultsLabel = new Label("Ничего не найдено");
        noResultsLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        vbox.getChildren().add(noResultsLabel);
        ticketListView.getItems().add(vbox);
    }

    @FXML
    private void navigateToBooking(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/aeroportfx/BookingTicket.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
