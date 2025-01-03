package org.example.aeroportfx.model;

public class Flight {
    private String flightNumber;
    private String destination;
    private String status;
    private String time;

    public Flight(String flightNumber, String destination, String status, String time) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.status = status;
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}