package dev.jabivullah.parking_lot_management_system.service;

import dev.jabivullah.parking_lot_management_system.entity.ParkingFloor;
import dev.jabivullah.parking_lot_management_system.entity.ParkingLot;
import dev.jabivullah.parking_lot_management_system.entity.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class ParkingSpotServiceImpl {
    @Autowired
    private ParkingLot parkingLot;
    @Autowired
    private List<ParkingFloor> parkingFloors;
    @Autowired
    private HashMap<String, ParkingSpot> parkingSpots;

    public ParkingSpot getParkingSpot(ParkingLot parkingLot) {
        return parkingSpot;
    }
}
