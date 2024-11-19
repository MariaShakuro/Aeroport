package com.aviation.core.entity;

import jakarta.persistence.*;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "tickets")
@XmlRootElement(name = "ticket")
public class TicketEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketNumber;
    @Column(name = "passengerName")
    private String passengerName;
    @Column(name = "passengerSurname")
    private String passengerSurname;
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
    private Date boardingTime;
    @Column(name = "departureTime")
    private Date departureTime;
    @Column(name = "gate")
    private String gate;
    @Column(name = "terminal")
    private Integer terminal;
    @Column(name = "classOfSeat")
    private Character classOfSeat;
    //Это будет Стринги?
    @Column(name = "bookingCode")
    private String bookingCode;
    //Мб Стринги?
    //Хочу уникальный штрихкод(как записать и куда?)
    @Column(name = "baggageIdNumber")
    private Long baggageIdNumber;
   @XmlElement
    public Long getTicketNumber(){
        return ticketNumber;
    }
    public void setTicketNumber(Long ticketNumber){
        this.ticketNumber=ticketNumber;
    }
    @XmlElement
    public String getPassengerName(){
        return passengerName;
    }
    public void setPassengerName(String passengerName){
        this.passengerName=passengerName;
    }
    @XmlElement
    public String getPassengerSurname(){
        return passengerSurname;
    }
    public void setPassengerSurname(String passengerSurname){
        this.passengerSurname=passengerSurname;
    }
    @XmlElement
    public String getCityOfRegistration(){
        return cityOfRegistration;
    }
    public void setCityOfRegistration(String cityOfRegistration){
        this.cityOfRegistration=cityOfRegistration;
    }
    @XmlElement
    public String getCityOfDestination(){
        return cityOfDestination;
    }
    public void setCityOfDestination(String cityOfDestination){
        this.cityOfDestination=cityOfDestination;
    }
    @XmlElement
    public String getSeat(){
        return seat;
    }
    public void setSeat(String seat){
        this.seat=seat;
    }
    @XmlElement
    public String getCarrierFlight(){
        return carrierFlight;
    }
    public void setCarrierFlight(String carrierFlight){
        this.carrierFlight=carrierFlight;
    }
    @XmlElement
    public Date getBoardingTime(){
        return boardingTime;
    }
    public void setBoardingTime(Date boardingTime){
        this.boardingTime=boardingTime;
    }
    @XmlElement
    public Date getDepartureTime(){
        return departureTime;
    }
    public void setDepartureTime(Date departureTime){
        this.departureTime=departureTime;
    }
    @XmlElement
    public String getGate(){
        return gate;
    }
    public void setGate(String gate){
        this.gate=gate;
    }
    @XmlElement
    public Integer getTerminal(){
        return terminal;
    }
    public void setTerminal(Integer terminal){
        this.terminal=terminal;
    }
    @XmlElement
    public Character getClassOfSeat(){
        return classOfSeat;
    }
    public void setClassOfSeat(Character classOfSeat){
        this.classOfSeat=classOfSeat;
    }
    @XmlElement
    public String getBookingCode(){
        return bookingCode;
    }
    public void setBookingCode(String bookingCode){
        this.bookingCode=bookingCode;
    }
    @XmlElement
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
