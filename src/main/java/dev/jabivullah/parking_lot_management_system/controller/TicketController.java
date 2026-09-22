package dev.jabivullah.parking_lot_management_system.controller;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponseDto;
import dev.jabivullah.parking_lot_management_system.service.ticket.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-lot-management-system")
public class TicketController {
    private TicketService ticketService;

    @GetMapping("/ticket/{ticketCode}")
    public ResponseEntity<TicketResponseDto> getTicket(@PathVariable String ticketCode){
        TicketResponseDto ticket = ticketService.getTicketByCode(ticketCode);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/ticket")
    public ResponseEntity<List<TicketResponseDto>> getTicketByDate(@RequestParam String date){
        List<TicketResponseDto> tickets = ticketService.getTicketsByDate(date);
        return ResponseEntity.ok(tickets);
    }

    @PostMapping("/ticket")
    public ResponseEntity<TicketResponseDto> createTicket(@RequestBody TicketRequestDto info){
        TicketResponseDto ticket = ticketService.createTicket(info);
        return ResponseEntity.ok(ticket);
    }
}
