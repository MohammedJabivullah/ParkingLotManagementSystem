package dev.jabivullah.parking_lot_management_system.service;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponceDto;

import java.time.Instant;
import java.util.Date;

public interface TicketService {
    TicketResponceDto getTicket(TicketRequestDto info);
    String generateId(String number, Instant time);

}
