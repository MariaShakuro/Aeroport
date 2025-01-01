package com.aviation.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketNumber;
    @Column(name = "passengerName")
    private String passengerName;
    @Column(name = "passengerSurname")
    private String passengerSurname;
    @Column(name = "passengerAge")
    private Integer passengerAge;
    @Column(name = "ticketPrice")
    private Double ticketPrice;
    @Column(name = "cityOfRegistration")
    private String cityOfRegistration;
    @Column(name = "cityOfDestination")
    private String cityOfDestination;
    @Column(name = "seat")
    private String seat;
    //Перевозчик+рейс
    @Column(name = "carrierFlight")
    private String carrierFlight;
    @Column(name = "boardingTime")
    private LocalDateTime boardingTime;
    @Column(name = "departureTime")
    private LocalDateTime departureTime;
    @Column(name = "gate")
    private String gate;
    @Column(name = "terminal")
    private Integer terminal;
    @Column(name = "classOfSeat")
    private Character classOfSeat;
    @Column(name = "bookingCode",unique = true)
    private String bookingCode;
    @Column(name = "baggageIdNumber")
    private Long baggageIdNumber;

    public Long getTicketNumber(){
        return ticketNumber;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setPassengerAge(Integer passengerAge) {
        this.passengerAge = passengerAge;
    }

    public Integer getPassengerAge() {
        return passengerAge;
    }

    public void setTicketNumber(Long ticketNumber){
        this.ticketNumber=ticketNumber;
    }

    public String getPassengerName(){
        return passengerName;
    }
    public void setPassengerName(String passengerName){
        this.passengerName=passengerName;
    }

    public String getPassengerSurname(){
        return passengerSurname;
    }
    public void setPassengerSurname(String passengerSurname){
        this.passengerSurname=passengerSurname;
    }

    public String getCityOfRegistration(){
        return cityOfRegistration;
    }
    public void setCityOfRegistration(String cityOfRegistration){
        this.cityOfRegistration=cityOfRegistration;
    }

    public String getCityOfDestination(){
        return cityOfDestination;
    }
    public void setCityOfDestination(String cityOfDestination){
        this.cityOfDestination=cityOfDestination;
    }

    public String getSeat(){
        return seat;
    }
    public void setSeat(String seat){
        this.seat=seat;
    }

    public String getCarrierFlight(){
        return carrierFlight;
    }
    public void setCarrierFlight(String carrierFlight){
        this.carrierFlight=carrierFlight;
    }

    public LocalDateTime getBoardingTime(){
        return boardingTime;
    }
    public void setBoardingTime(LocalDateTime boardingTime){
        this.boardingTime=boardingTime;
    }

    public LocalDateTime getDepartureTime(){
        return departureTime;
    }
    public void setDepartureTime(LocalDateTime departureTime){
        this.departureTime=departureTime;
    }

    public String getGate(){
        return gate;
    }
    public void setGate(String gate){
        this.gate=gate;
    }

    public Integer getTerminal(){
        return terminal;
    }
    public void setTerminal(Integer terminal){
        this.terminal=terminal;
    }

    public Character getClassOfSeat(){
        return classOfSeat;
    }
    public void setClassOfSeat(Character classOfSeat){
        this.classOfSeat=classOfSeat;
    }

    public String getBookingCode(){
        return bookingCode;
    }
    public void setBookingCode(String bookingCode){
        this.bookingCode=bookingCode;
    }

    public Long getBaggageIdNumber(){
        return baggageIdNumber;
    }
    public void setBaggageIdNumber(Long baggageIdNumber){
        this.baggageIdNumber=baggageIdNumber;
    }
    @Override
    public String toString(){
        return "Ticket{" +
                "passengerName=" +passengerName+
                "passengerSurname=" +passengerSurname+
                "cityOfRegistration=" +cityOfRegistration+
                "cityOfDestination=" +cityOfDestination+
                "seat" + seat+
                "carrierFlight=" +carrierFlight+
                "boardingTime=" +boardingTime+
                "departureTime=" +departureTime+
                "gate=" +gate+
                "terminal=" +terminal+
                "classOfSeat=" +classOfSeat+
                "bookingCode=" +bookingCode+
                "baggageNumber=" +baggageIdNumber+
                "}";
    }
}
