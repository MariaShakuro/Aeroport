package com.aviation.core.DTO;

import java.util.Date;

public class TicketDTO {
    private Long ticketNumber;
    private String passengerName;
    private String passengerSurname;
    private String cityOfRegistration;
    private String cityOfDestination;
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
    public Long getTicketNumber(){
        return ticketNumber;
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
    public Date getBoardingTime(){
        return boardingTime;
    }
    public void setBoardingTime(Date boardingTime){
        this.boardingTime=boardingTime;
    }
    public Date getDepartureTime(){
        return departureTime;
    }
    public void setDepartureTime(Date departureTime){
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


}
