package com.crew.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private FlightRepository flightRepository;

    public void createOrUpdateSchedule() {
        List<FlightData> flightDataList = getFlightDataFromAirlinesAndAirports();
        for (FlightData flightData : flightDataList) {
            FlightEntity existingFlight = flightRepository.findByFlightNumber(flightData.getFlightNumber());
            if (existingFlight != null) {
                existingFlight.setDepartureTime(flightData.getDepartureTime());
                existingFlight.setArrivalTime(flightData.getArrivalTime());
                existingFlight.setStatus(flightData.getStatus());
                flightRepository.save(existingFlight);
            } else {
                FlightEntity newFlight = new FlightEntity();
                newFlight.setFlightNumber(flightData.getFlightNumber());
                newFlight.setDepartureAirport(flightData.getDepartureAirport());
                newFlight.setArrivalAirport(flightData.getArrivalAirport());
                newFlight.setDepartureTime(flightData.getDepartureTime());
                newFlight.setArrivalTime(flightData.getArrivalTime());
                newFlight.setStatus(flightData.getStatus());
                flightRepository.save(newFlight);
            }
        }
    }

    private List<FlightData> getFlightDataFromAirlinesAndAirports() {
        return new ArrayList<>();
    }
}
