package com.aviation.core.service;

import com.aviation.core.entity.Display;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisplayService {
    @Autowired
    private RestTemplate restTemplate;
   // public List<Display>getFlightDisplay(){
       /* ResponseEntity<Flight[]>response=restTemplate.getForEntity("http://localhost:8080/api/flights",Flight[].class);
        Flight[] flights=response.getBody();
        List<Display>displays=new ArrayList<>();
        for(Flight flight : flights){
            Display display=new Display();
            display.set(flight.getFlight());
            display.set(flight.getArrivalCity());
            display.set(flight.getArrivalTime());
            displays.add(display);
        }*/
    //}
}
