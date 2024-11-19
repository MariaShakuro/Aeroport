package com.aviation.core.DTO;

import java.util.Date;

public class FlightDTO {
    private Long id;
    private String personalID;
    private String flight;
    private String city;
    private Date time;
    private String status;
    // Геттеры и сеттеры
    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public String getPersonalID() {
        return personalID;
    }
    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }
    public String getFlight() {
        return flight;
    }
    public void setFlight(String flight) {
        this.flight = flight;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time =time;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


}
