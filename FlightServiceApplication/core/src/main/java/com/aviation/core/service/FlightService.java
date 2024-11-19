package com.aviation.core.service;

import com.aviation.core.entity.FlightEntity;
import com.aviation.core.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<FlightEntity>getAllFlights(){
        return flightRepository.findAll();
    }
    public FlightEntity saveFlight(FlightEntity flight){
        return flightRepository.save(flight);
    }
    public void deleteFlight(Long id){
        flightRepository.deleteById(id);
    }
}
