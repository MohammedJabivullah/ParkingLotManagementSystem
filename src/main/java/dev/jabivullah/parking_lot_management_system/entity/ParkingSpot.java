package dev.jabivullah.parking_lot_management_system.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ParkingSpot extends BaseEntity{
    private int spotNumber;
    private ParkingFloor parkingFloor;
    private ParkingSpotStatus parkingSpotStatus;
    private List<VechicleType> supportedVechicleTypes;
}
