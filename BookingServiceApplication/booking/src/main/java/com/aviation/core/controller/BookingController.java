package com.aviation.core.controller;


import com.aviation.core.entity.Booking;
import com.aviation.core.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }
}