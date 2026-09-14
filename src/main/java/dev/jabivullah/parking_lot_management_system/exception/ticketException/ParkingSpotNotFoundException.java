package dev.jabivullah.parking_lot_management_system.exception.ticketException;

public class ParkingSpotNotFoundException extends RuntimeException {
    public ParkingSpotNotFoundException(String message) {
        super(message);
    }
}
