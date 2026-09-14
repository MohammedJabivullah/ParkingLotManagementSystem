package dev.jabivullah.parking_lot_management_system.service.ticket;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponseDto;

public interface TicketService {
    TicketResponseDto creatTicket(TicketRequestDto ticketRequestDto);
}
