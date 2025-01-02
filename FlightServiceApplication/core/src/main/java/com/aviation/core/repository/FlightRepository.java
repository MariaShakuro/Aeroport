package com.aviation.core.repository;

import org.springframework.stereotype.Repository;
import com.aviation.core.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity,Long> {
  List<FlightEntity> findByDepartureAirportAndArrivalAirportAndDepartureTimeBetween(String departureAirport, String arrivalAirport, LocalDateTime start,LocalDateTime end);
}
