package dev.jabivullah.parking_lot_management_system.service.ticket;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponseDto;

import java.util.List;

public interface TicketService {
    TicketResponseDto createTicket(TicketRequestDto ticketRequestDto);
    TicketResponseDto getTicketByCode(String ticketCode);
    List<TicketResponseDto> getTicketsByDate(String date);
}
