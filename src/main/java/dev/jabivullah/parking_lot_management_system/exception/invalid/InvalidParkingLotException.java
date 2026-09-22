package dev.jabivullah.parking_lot_management_system.exception.invalid;

import dev.jabivullah.parking_lot_management_system.exception.base.InvalidInputException;

public class InvalidParkingLotException extends InvalidInputException {
    public InvalidParkingLotException(String message){
        super(message);
    }
}
