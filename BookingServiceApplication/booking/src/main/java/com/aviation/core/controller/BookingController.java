package com.aviation.core.controller;


import com.aviation.core.entity.Booking;
import com.aviation.core.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    // @GetMapping("/{ticketNumber}")
   /* public Booking getBookingByTicketNumber(@PathVariable String ticketNumber){
        return bookingService.findByTicketNumber(ticketNumber);
    }*/
    @PostMapping
    public Mono<ResponseEntity<Booking>> createBooking(@RequestBody Booking bookingRequest) {
        return bookingService.createBooking(bookingRequest)
                .map(savedBooking->ResponseEntity.status(HttpStatus.CREATED).body(savedBooking))
                .onErrorResume(e->Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)));
    }
}