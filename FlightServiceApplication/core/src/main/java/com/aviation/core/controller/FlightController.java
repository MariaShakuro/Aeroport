package com.aviation.core.controller;

import com.aviation.core.entity.FlightEntity;
import com.aviation.core.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;
   @GetMapping("/{id}/{format}")
    public ResponseEntity<?>getFlights(@PathVariable Long id,@PathVariable String format){
       try{
           String result=flightService.getFlightInfo(id,format);
           return ResponseEntity.ok(result);
       }catch(Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error");
       }
   }
}

