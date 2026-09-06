package dev.jabivullah.parking_lot_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class ParkingFloor extends BaseEntity{
    private int floorNumber;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "parkingFloor", cascade = CascadeType.ALL)
    private List<ParkingSpot> parkingSpot;

    @Enumerated(EnumType.STRING)
    private ParkingFloorStatus parkingFloorStatus;
}
