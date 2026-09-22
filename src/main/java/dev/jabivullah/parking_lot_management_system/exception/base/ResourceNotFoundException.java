package dev.jabivullah.parking_lot_management_system.exception.base;

public abstract class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }

    protected ResourceNotFoundException() {
    }
}
