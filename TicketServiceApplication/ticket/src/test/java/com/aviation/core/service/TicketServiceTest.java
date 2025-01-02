package com.aviation.core.service;

import com.aviation.core.DTO.TicketDTO;
import com.aviation.core.entity.TicketEntity;
import com.aviation.core.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import com.google.zxing.WriterException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@SpringBootTest
class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private TicketDTO ticketDTO;

    private TicketEntity ticket;

    @BeforeEach
    void setUp() {
        ticket = new TicketEntity();
        ticket.setPassengerName("Shakuro");
        ticket.setPassengerSurname("Maria");
        ticket.setPassengerAge(30);
        ticket.setTicketPrice(100.0);
        ticket.setCityOfRegistration("New York");
        ticket.setCityOfDestination("Los Angeles");
        ticket.setSeat("12A");
        ticket.setCarrierFlight("NY123");
        ticket.setBoardingTime(LocalDateTime.now());
        ticket.setDepartureTime(LocalDateTime.now().plusHours(2));
        ticket.setTerminal(1);
        ticket.setClassOfSeat('E');
        ticket.setBookingCode("ABC123");
        ticket.setBaggageIdNumber(45L);
    }

    @Test
    void testCreateTicket() throws WriterException, IOException, NoSuchAlgorithmException {
        when(ticketRepository.save(any(TicketEntity.class))).thenReturn(ticket);
        TicketEntity createdTicket = ticketService.createTicket(ticket);
        assertNotNull(createdTicket);
        verify(ticketRepository, times(1)).save(ticket);
    }

    @Test
    void testDeleteTicket() {
        doNothing().when(ticketRepository).deleteById(anyLong());
        ticketService.deleteTicket(1L);
        verify(ticketRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateTicketPrice() {
        when(ticketRepository.findByPassengerSurnameAndPassengerName(anyString(), anyString())).thenReturn(ticket);
        when(ticketRepository.save(any(TicketEntity.class))).thenReturn(ticket);

        TicketEntity updatedTicket = ticketService.updateTicketPrice("Shakuro", "Maria", "lifegood", true, 100);
        assertNotNull(updatedTicket);
        assertEquals(50.0, updatedTicket.getTicketPrice());
        verify(ticketRepository, times(1)).findByPassengerSurnameAndPassengerName("Shakuro", "Maria");
        verify(ticketRepository, times(1)).save(ticket);
    }
}
