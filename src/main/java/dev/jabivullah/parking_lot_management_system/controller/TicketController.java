package dev.jabivullah.parking_lot_management_system.controller;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponseDto;
import dev.jabivullah.parking_lot_management_system.service.ticket.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-lot-management-system")
public class TicketController {
    private TicketService ticketService;

    // To be Done
//    @GetMapping("/ticket")
//    public ResponseEntity<List<TicketResponceDto>> getAllTickets(){
//        List<TicketResponceDto> tickets = ticketService.getAllTickets();
//        return ResponseEntity.ok(tickets);
//    }

//    @GetMapping("/ticket/{ticketCode}")
//    public ResponseEntity<TicketResponseDto> getTicket(@PathVariable String ticketCode){
//        TicketResponseDto ticket = ticketService.getTicketByCode(ticketCode);
//        return ResponseEntity.ok(ticket);
//    }


    @PostMapping("/ticket")
    public ResponseEntity<TicketResponseDto> createTicket(@RequestBody TicketRequestDto info){
        TicketResponseDto ticket = ticketService.creatTicket(info);
        return ResponseEntity.ok(ticket);
    }


}
