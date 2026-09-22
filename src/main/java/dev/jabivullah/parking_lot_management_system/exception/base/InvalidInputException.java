package dev.jabivullah.parking_lot_management_system.exception.base;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message){
        super(message);
    }
}
