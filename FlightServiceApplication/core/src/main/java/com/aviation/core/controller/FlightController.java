package com.aviation.core.controller;

import com.aviation.core.DTO.FlightDTO;
import com.aviation.core.entity.FlightEntity;
import com.aviation.core.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return flightService.getAllFlights().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    @PostMapping
    public FlightDTO createFlight(@RequestBody FlightDTO flightDTO) {
        FlightEntity flightEntity = convertToEntity(flightDTO);
        FlightEntity savedEntity=flightService.saveFlight(flightEntity);
       /* flightEntity.setId(flightDTO.getId());
        flightEntity.setFlight(flightDTO.getFlight());
        flightEntity.setCity(flightDTO.getCity());
        flightEntity.setTime(flightDTO.getTime());
        flightEntity.setStatus(flightDTO.getStatus());
        Flight savedEntity = flightRepository.save(flightEntity);
        */
        return convertToDTO(savedEntity);
    }
    @PutMapping("/{id}")
    public FlightDTO updateFlight(@PathVariable Long id, @RequestBody FlightDTO flightDTO) {
        FlightEntity flightEntity = convertToEntity(flightDTO);
         flightEntity.setId(id);// Устанавливаем идентификатор для обновления существующей записи
         FlightEntity updatedEntity = flightService.saveFlight(flightEntity);
         return convertToDTO(updatedEntity);

    }
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
    }
    private FlightDTO convertToDTO(FlightEntity flightEntity) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setId(flightEntity.getId());
        flightDTO.setPersonalID(flightEntity.getPersonalID());
        flightDTO.setFlight(flightEntity.getFlight());
        flightDTO.setCity(flightEntity.getCity());
        flightDTO.setTime(flightEntity.getTime());
        flightDTO.setStatus(flightEntity.getStatus());
        return flightDTO;
    }
    private FlightEntity convertToEntity(FlightDTO flightDTO){
        FlightEntity flightEntity=new FlightEntity();
        flightEntity.setPersonalID(flightEntity.getPersonalID());
        flightEntity.setFlight(flightDTO.getFlight());
        flightEntity.setCity(flightDTO.getCity());
        flightEntity.setTime(flightDTO.getTime());
        flightEntity.setStatus(flightDTO.getStatus());
        return flightEntity;
    }
   /* @Autowired
    private FlightService flightService;
    @GetMapping
    public List<Flight>getAllFlights(){
        return flightService.getAllFlights();
    }
    @PostMapping
    public Flight createFlight(@RequestBody Flight flight){
        return flightService.saveFlights(flight);
    }*/
}

