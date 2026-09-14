package dev.jabivullah.parking_lot_management_system.exception.ticketException;

public class GateNotFoundException extends RuntimeException {
    public GateNotFoundException(String message) {
        super(message);
    }
}
