package dev.jabivullah.parking_lot_management_system.service;

import dev.jabivullah.parking_lot_management_system.dto.TicketRequestDto;
import dev.jabivullah.parking_lot_management_system.dto.TicketResponceDto;
import dev.jabivullah.parking_lot_management_system.entity.Ticket;
import dev.jabivullah.parking_lot_management_system.repository.VechicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public class TicketServiceImpl implements TicketService{
    @Autowired
    VechicleRepository vechicleRepository;

    @Override
    public TicketResponceDto getTicket(TicketRequestDto info) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(generateId(info.getVechicleNumber(), info.getTime()));
        ticket.setNumber(info.getVechicleNumber());
        ticket.setVehicle();
//                vechicleRepository.findByNumber(info.getVechicleNumber())
        return null;
    }

    public String generateId(String number, Instant time){
        return "UnderProcess";
    }
}
