package com.aviation.core.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FLIGHTS")
//для явного указания типа доступа.
//@Access(AccessType.FIELD)
public class FlightEntity {
    //ID(ключ для бд)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //ID
    private String personalID;
    //Рейс
    private String flight;
    //Страна-страна
    private String city;
    //Время прилета/отлета
    private Date time;
    //Статус
    private String status;


}
