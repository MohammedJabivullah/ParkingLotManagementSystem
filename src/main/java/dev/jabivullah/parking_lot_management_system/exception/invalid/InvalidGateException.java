package dev.jabivullah.parking_lot_management_system.exception.invalid;

import dev.jabivullah.parking_lot_management_system.exception.base.InvalidInputException;

public class InvalidGateException extends InvalidInputException {
    public InvalidGateException(String message){
        super(message);
    }
}
