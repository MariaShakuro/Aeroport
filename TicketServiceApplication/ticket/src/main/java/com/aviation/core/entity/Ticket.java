package com.aviation.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Date;

@Entity
public class Ticket {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passengerName;
    private String passengerSurname;
    private String cityOfRegistration;
    private String cityOfDestionation;
    private String seat;
    private String carrierFlight;//Перевозчик+рейс
    private Date boardingTime;
    private Date departureTime;
    private String gate;
    private Integer terminal;
    private Character classOfSeat;
    //Это будет Стринги?
    private String bookingCode;
    //Мб Стринги?
    private Long baggageIdNumber;
    //Хочу уникальный штрихкод(как записать и куда?)

    //Геттеры и сеттеры
    public void set(Long id,String passengerName,String passengerSurname,String cityOfRegistration,
                    String cityOfDestionation,String seat,String carrierFlight,Date boardingTime,Date departureTime,
                    String gate,int terminal,char classOfSeat,String bookingCode,Long baggageIdNumber){
        this.id=id;
        this.passengerName=passengerName;
        this.passengerSurname=passengerSurname;
        this.cityOfRegistration=cityOfRegistration;
        this.cityOfDestionation=cityOfDestionation;
        this.seat=seat;
        this.carrierFlight=carrierFlight;
        this.boardingTime=boardingTime;
        this.departureTime=departureTime;
        this.gate=gate;
        this.terminal=terminal;
        this.classOfSeat=classOfSeat;
        this.bookingCode=bookingCode;
        this.baggageIdNumber=baggageIdNumber;

    }

    public String getPassengerName(){return passengerName;}
    public String getPassengerSurname(){return passengerSurname;}
    public String getCityOfRegistration(){return cityOfRegistration;}
    public String getCityOfDestionation(){return cityOfDestionation;}
    public String getSeat(){return seat;}
    public String getCarrierFlight(){return carrierFlight;}
    public Date getBoardingTime(){return boardingTime;}
    public Date getDepartureTime(){return departureTime;}
    public String getGate(){return gate;}
    public Integer getTerminal(){return terminal;}
    public Character getClassOfSeat(){return classOfSeat;}
    public String getBookingCode(){return bookingCode;}
    public Long getBaggageIdNumber(){return baggageIdNumber;}


}
