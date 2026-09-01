package dev.jabivullah.parking_lot_management_system.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingLot extends BaseEntity{
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<VechicleType> supportedVechicleTypes;
    private ParkingSpotStatus parkingLotStatus;
}
