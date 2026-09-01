package dev.jabivullah.parking_lot_management_system.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseEntity{
    private List<ParkingSpot> parkingSpot;
    private int floorNumber;
    private ParkingFloorStatus parkingFloorStatus;
}
