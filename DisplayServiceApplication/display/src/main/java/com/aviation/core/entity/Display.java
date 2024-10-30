package com.aviation.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity

public class Display {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String flight;
    private String arrivalCity;
    private Date arrivalTime;
    private Date takeOffTime;
    private String status;
    private String gate;
    private Integer terminal;

    public void set(String flight,String arrivalCity,Date arrivalTime,
                    Date takeOffTime,String status,String gate,Integer terminal){
        this.flight=flight;
        this.arrivalCity=arrivalCity;
        this.arrivalTime=arrivalTime;
        this.takeOffTime=takeOffTime;
        this.status=status;
        this.gate=gate;
        this.terminal=terminal;
    }
    public String getFlight(){return flight;}
    public String getArrivalCity(){return arrivalCity;}
    public Date getArrivalTime(){return arrivalTime;}
    public Date getTakeOffTime(){return takeOffTime;}
    public String getStatus(){return status;}
    public String getGate(){return gate;}
    public Integer getTerminal(){return terminal;}

}
