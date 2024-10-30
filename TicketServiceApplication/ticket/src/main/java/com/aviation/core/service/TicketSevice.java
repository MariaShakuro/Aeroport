package com.aviation.core.service;

import com.aviation.core.entity.Ticket;
import com.aviation.core.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketSevice {
    @Autowired
    private TicketRepository ticketRepository;
    public Ticket saveTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public void deleteTicket(String ticketNumber){
        Ticket ticket=ticketRepository.findByTicketNumber(ticketNumber);
        ticketRepository.delete(ticket);
    }
}
