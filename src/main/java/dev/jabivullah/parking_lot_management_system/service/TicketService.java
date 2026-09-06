package dev.jabivullah.parking_lot_management_system.service;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponceDto;

import java.time.Instant;

public interface TicketService {
    TicketResponceDto creatTicket(TicketRequestDto ticketRequestDto);
}
