package dev.jabivullah.parking_lot_management_system.service.parkingspot;

import dev.jabivullah.parking_lot_management_system.entity.*;
import dev.jabivullah.parking_lot_management_system.exception.ticketException.ParkingSpotNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ParkingSpotServiceImpl {
    @Autowired
    private List<ParkingFloor> parkingFloors;
    @Autowired
    private List<ParkingSpot> parkingSpots;

    public ParkingSpot getParkingSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        parkingFloors = parkingLot.getParkingFloors();
        for(ParkingFloor floor : parkingFloors){
            parkingSpots = floor.getParkingSpot();
            for(ParkingSpot spot : parkingSpots){
                if(spot.getSupportedVechicleType() == vehicleType && spot.getParkingSpotStatus() == ParkingSpotStatus.EMPTY){
                    return spot;
                }
            }
        }
        throw new ParkingSpotNotFoundException(vehicleType+" Parking Spots Are Full!");
    }
}
