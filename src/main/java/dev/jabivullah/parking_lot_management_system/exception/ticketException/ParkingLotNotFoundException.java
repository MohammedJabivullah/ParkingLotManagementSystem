package dev.jabivullah.parking_lot_management_system.exception.ticketException;

public class ParkingLotNotFoundException extends RuntimeException {
    public ParkingLotNotFoundException(String message) {
        super(message);
    }
}
