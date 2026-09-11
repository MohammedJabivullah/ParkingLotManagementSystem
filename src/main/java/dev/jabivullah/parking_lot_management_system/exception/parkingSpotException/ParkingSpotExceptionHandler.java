package dev.jabivullah.parking_lot_management_system.exception.parkingSpotException;

import dev.jabivullah.parking_lot_management_system.controller.TicketController;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(basePackageClasses = TicketController.class)
public class ParkingSpotExceptionHandler {
}
