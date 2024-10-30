package com.aviation.core.repository;

import com.aviation.core.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
   List<Booking>findByFlightNumber(String flightNumber);
   Booking findByTicketNumber(String ticketNumber);
}
