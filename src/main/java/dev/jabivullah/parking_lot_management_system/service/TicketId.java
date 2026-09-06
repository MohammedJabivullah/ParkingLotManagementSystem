package dev.jabivullah.parking_lot_management_system.service;

import java.time.Instant;

public class TicketId {
    private String ticketId;

    public TicketId(String vehicleNo, String gateId, String operaterId){
        Instant time = Instant.now();
        String s = time.toString();
    }
}
