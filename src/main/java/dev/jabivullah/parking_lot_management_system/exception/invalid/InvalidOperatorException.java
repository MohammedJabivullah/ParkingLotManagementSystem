package dev.jabivullah.parking_lot_management_system.exception.invalid;

import dev.jabivullah.parking_lot_management_system.exception.base.InvalidInputException;

public class InvalidOperatorException extends InvalidInputException {
    public InvalidOperatorException(String message){
        super(message);
    }
}
