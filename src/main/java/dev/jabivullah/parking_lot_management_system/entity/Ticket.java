package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Ticket extends BaseEntity{
    private String ticketCode;
    private Instant entryTime;
    private String date;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "parking_spot_id")
    private ParkingSpot parkingSpot;
    @ManyToOne
    @JoinColumn(name = "gate_id")
    private Gate gate;
    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Operator operator;
}
