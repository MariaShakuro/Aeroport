package com.aviation.core.controller;


import com.aviation.core.DTO.TicketDTO;
import com.aviation.core.entity.TicketEntity;
import com.aviation.core.service.TicketSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketSevice ticketSevice;
    @PostMapping
    public TicketEntity createTicket(@RequestBody TicketEntity ticketEntity){
        return ticketSevice.saveTicket(ticketEntity);
    }
    @DeleteMapping("/{ticketNumber}")
    public void deleteTicket(@PathVariable Long ticketNumber){
        ticketSevice.deleteTicket(ticketNumber);
    }
   /* private TicketEntity convertToEntity(TicketDTO ticketDTO){
        TicketEntity ticketEntity=new TicketEntity();
        ticketEntity.setPassengerName(ticketEntity.getPassengerName());
        ticketEntity.setPassengerSurname(ticketDTO.getPassengerSurname());
        ticketEntity.setCityOfRegistration(ticketDTO.getCityOfRegistration());
        ticketEntity.setCityOfDestination(ticketDTO.getCityOfDestination());
        ticketEntity.setSeat(ticketDTO.getSeat());
        ticketEntity.setCarrierFlight(ticketDTO.getCarrierFlight());
        ticketEntity.setBoardingTime(ticketDTO.getBoardingTime());
        ticketEntity.setDepartureTime(ticketDTO.getDepartureTime());
        ticketEntity.setGate(ticketDTO.getGate());
        ticketEntity.setTerminal(ticketDTO.getTerminal());
        ticketEntity.setClassOfSeat(ticketDTO.getClassOfSeat());
        ticketEntity.setBookingCode(ticketDTO.getBookingCode());
        ticketEntity.setBaggageIdNumber(ticketDTO.getBaggageIdNumber());



        return ticketEntity;
    }*/
}
