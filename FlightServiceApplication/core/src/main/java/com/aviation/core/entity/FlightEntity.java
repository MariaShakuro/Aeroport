package com.aviation.core.entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FLIGHTS")
//для явного указания типа доступа.
//@Access(AccessType.FIELD)
public class FlightEntity {
    //ID(ключ для бд)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //ID
    @Column(name = "PERSONAL_ID")
    private String personalID;
    //Рейс
    @Column(name = "FLIGHT")
    private String flight;
    //Страна-страна
    @Column(name = "CITY")
    private String city;
    //Время прилета/отлета
    @Column(name = "TIME")
    private Date time;
    //Статус
    @Column(name = "STATUS")
    private String status;
    //Gets and sets
    public void setId(Long id){
        this.id=id;
    }
    public void setPersonalID(String personalID){
        this.personalID=personalID;
    }
    public void setFlight(String flight){
        this.flight=flight;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setTime(Date time){
        this.time=time;
    }
    public void setStatus(String status){
        this.status=status;
    }

    public Long getId(){
        return id;
    }
    public String getPersonalID(){
        return personalID;
    }
    public String getFlight(){
        return flight;
    }
    public String getCity(){
        return city;
    }
    public Date getTime(){
        return time;
    }
    public String getStatus(){
        return status;
    }
    @Override
    public String toString(){
        return "Flight{" +
                "id=" + id +
                "flight=" + flight +
                "city=" + city +
                "time" + time +
                "status" + status +
                "}";
    }

}
