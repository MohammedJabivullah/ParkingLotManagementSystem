package dev.jabivullah.parking_lot_management_system.dto;

import dev.jabivullah.parking_lot_management_system.entity.ParkingSpot;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TicketResponceDto {
    private String ticketId;
    private String vechicleNumber;
    private Instant time;
    private String gateId;
    private String operaterId;
    private ParkingSpot parkingSpot;
}
