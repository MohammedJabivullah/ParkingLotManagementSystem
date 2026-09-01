package dev.jabivullah.parking_lot_management_system.dto;

import dev.jabivullah.parking_lot_management_system.entity.Gate;
import dev.jabivullah.parking_lot_management_system.entity.Operator;
import dev.jabivullah.parking_lot_management_system.entity.ParkingSpot;
import dev.jabivullah.parking_lot_management_system.entity.Vehicle;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
public class TicketRequestDto {
    private String vechicleNumber;
    private String ownerName;
    @CreationTimestamp
    private Instant time;
    private Long gateId;
    private Long operatorId;
}

