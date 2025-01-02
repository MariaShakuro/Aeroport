package com.aviation.core.controller;

import com.aviation.core.entity.FlightEntity;
import com.aviation.core.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping("/create")
    public ResponseEntity<FlightEntity>createFlight(@RequestBody FlightEntity flight){
         FlightEntity createdFlight=flightService.createFlight(flight);
         return new ResponseEntity<>(createdFlight,HttpStatus.CREATED);
    }
    /*@GetMapping("/search")
    public ResponseEntity<List<FlightEntity>>searchFlights(@RequestParam String departureAirport, @RequestParam String arrivalAirport,
                                                           @RequestParam LocalDateTime start,@RequestParam LocalDateTime end){
        List<FlightEntity>flights=flightService.getFlights(departureAirport,arrivalAirport,start,end);
        return new ResponseEntity<>(flights,HttpStatus.OK);
    }*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FlightEntity> updateFlight(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        FlightEntity updatedFlight = flightService.updateFlight(id, updates);
        return ResponseEntity.ok(updatedFlight);
    }
    @GetMapping
    public ResponseEntity<List<FlightEntity>> getFlights(@RequestParam String departureAirport, @RequestParam String arrivalAirport,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        List<FlightEntity> flights = flightService.getFlights(departureAirport, arrivalAirport, start, end);
        return ResponseEntity.ok(flights);
    }

}

