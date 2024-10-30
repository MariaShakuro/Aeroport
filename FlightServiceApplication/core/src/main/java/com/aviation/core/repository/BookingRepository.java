package com.aviation.core.repository;

import com.aviation.core.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
