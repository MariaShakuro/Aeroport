package com.aviation.core.service;

import com.aviation.core.entity.Flight;
import com.aviation.core.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    public List<Flight>getAllFlights(){
        return flightRepository.findAll();
    }
    public Flight saveFlights(Flight flight){
        return flightRepository.save(flight);
    }
}
