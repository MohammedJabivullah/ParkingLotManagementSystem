package dev.jabivullah.parking_lot_management_system.exception.notfound;

import dev.jabivullah.parking_lot_management_system.exception.base.ResourceNotFoundException;

public class ParkingSpotNotFoundException extends ResourceNotFoundException {
    public ParkingSpotNotFoundException(String message){
        super(message);
    }
}
