package com.aviation.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.awt.font.LayoutPath;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //ID
    private Long id;
    //Рейс
    private String flight;
    //Страна-страна
    private String city;
    //Врем прилета/отлета
    private Date time;
    //Статус
    private String status;
    //Gets and sets
}
