package com.aviation.core.service;

import com.aviation.core.entity.FlightEntity;
import com.aviation.core.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public FlightEntity createFlight(FlightEntity flight) {
        return flightRepository.save(flight);
    }
    public void deleteFlight(Long flightId){
        FlightEntity flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));
        flightRepository.delete(flight);
    }
    public List<FlightEntity> getAllFlights() {
        return flightRepository.findAll();
    }
    public FlightEntity updateFlight(Long flightId, Map<String, Object> updates) {
        FlightEntity flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));
        updates.forEach((key, value) -> {
            switch (key) {
                case "CityOfRegistration":
                    flight.setCityOfRegistration((String) value);
                    break;
                case "CityOfDestination":
                    flight.setCityOfDestination((String) value);
                    break;
                case "departureTime":
                    flight.setDepartureTime((LocalDateTime) value);
                    break;
                case "arrivalTime":
                    flight.setArrivalTime((LocalDateTime) value);
                    break;
                case "status":
                    flight.setStatus((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });
        return flightRepository.save(flight);
    }

}



