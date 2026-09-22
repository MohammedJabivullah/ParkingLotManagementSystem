package dev.jabivullah.parking_lot_management_system.service.parkingspot;

import dev.jabivullah.parking_lot_management_system.entity.ParkingLot;
import dev.jabivullah.parking_lot_management_system.entity.ParkingSpot;
import dev.jabivullah.parking_lot_management_system.entity.VehicleType;

public interface ParkingSpotService {
    ParkingSpot getParkingSpot(ParkingLot parkingLot, VehicleType vehicleType);
}
