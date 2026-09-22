package dev.jabivullah.parking_lot_management_system.exception.notfound;

import dev.jabivullah.parking_lot_management_system.exception.base.ResourceNotFoundException;

import java.lang.module.ResolutionException;

public class ParkingFloorNotFoundException extends ResourceNotFoundException {
    public ParkingFloorNotFoundException(String message){
        super(message);
    }
}
