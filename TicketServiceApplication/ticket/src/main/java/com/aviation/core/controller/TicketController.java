package com.aviation.core.controller;


import com.aviation.core.entity.Ticket;
import com.aviation.core.service.TicketSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    private TicketSevice ticketSevice;
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketSevice.saveTicket(ticket);
    }
    @DeleteMapping("/{ticketNumber}")
    public void deleteTicket(@PathVariable String ticketNumber){
        ticketSevice.deleteTicket(ticketNumber);
    }
}
