package dev.jabivullah.parking_lot_management_system.exception.notfound;

import dev.jabivullah.parking_lot_management_system.exception.base.ResourceNotFoundException;

public class ParkingLotNotFoundException extends ResourceNotFoundException {
    public ParkingLotNotFoundException(String message){
        super(message);
    }
}
