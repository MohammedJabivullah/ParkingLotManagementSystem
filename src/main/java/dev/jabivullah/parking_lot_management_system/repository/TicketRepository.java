package dev.jabivullah.parking_lot_management_system.repository;

import dev.jabivullah.parking_lot_management_system.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    Optional<List<Ticket>> findByDate(String date);
    Optional<Ticket> findByTicketCode(String ticketCode);
}
