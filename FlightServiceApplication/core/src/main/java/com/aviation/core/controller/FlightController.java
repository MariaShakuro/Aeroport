package com.aviation.core.controller;


import com.aviation.core.entity.Flight;
import com.aviation.core.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @GetMapping
    public List<Flight>getAllFlights(){
        return flightService.getAllFlights();
    }
    @PostMapping
    public Flight createFlight(@RequestBody Flight flight){
        return flightService.saveFlights(flight);
    }
}
