package com.aviation.core.repository;

import com.aviation.core.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    TicketEntity findByTicketNumber(Long ticketNumber);
}
