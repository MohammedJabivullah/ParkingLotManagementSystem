package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class ParkingSpot extends BaseEntity{
    private int spotNumber;

    @ManyToOne
    @JoinColumn(name = "parking_floor_id")
    private ParkingFloor parkingFloor;

    @Enumerated(EnumType.STRING)
    private ParkingSpotStatus parkingSpotStatus;

    @Enumerated(EnumType.STRING)
    private VehicleType supportedVechicleType;
}
