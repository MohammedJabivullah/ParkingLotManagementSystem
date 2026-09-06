package dev.jabivullah.parking_lot_management_system.controller;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponceDto;
import dev.jabivullah.parking_lot_management_system.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    private TicketService ticketService;

    @PostMapping("PLMS")
    public ResponseEntity<TicketResponceDto> getTicket(@RequestBody TicketRequestDto info){
        TicketResponceDto ticket = ticketService.creatTicket(info);
        return ResponseEntity.ok(ticket);
    }


}
