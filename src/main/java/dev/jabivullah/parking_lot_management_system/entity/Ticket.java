package dev.jabivullah.parking_lot_management_system.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Ticket extends BaseEntity{
    private String ticketId;
    private String number;
    private Instant entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private UUID gateId;
    private UUID operatorId;
}
