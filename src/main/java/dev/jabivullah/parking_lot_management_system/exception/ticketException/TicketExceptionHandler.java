package dev.jabivullah.parking_lot_management_system.exception.ticketException;

import dev.jabivullah.parking_lot_management_system.controller.TicketController;
import dev.jabivullah.parking_lot_management_system.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = TicketController.class)
public class TicketExceptionHandler {

    @ExceptionHandler(ParkingLotNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleParkingLotNotFoundException(ParkingLotNotFoundException ex){
        ExceptionResponseDto responceDto = new ExceptionResponseDto(ex.getMessage(), 404);

        return new ResponseEntity<>(responceDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ParkingSpotNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handlePSNotFoundException(ParkingSpotNotFoundException ex){
        ExceptionResponseDto parkingSpotNotFoundExceptionResponceDto = new ExceptionResponseDto(ex.getMessage(), 404);

        return new ResponseEntity<>(parkingSpotNotFoundExceptionResponceDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GateNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleGateNotFoundException(GateNotFoundException ex){
        ExceptionResponseDto gateNotFoundResponceDto =new ExceptionResponseDto(ex.getMessage(), 400);

        return new ResponseEntity<>(gateNotFoundResponceDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OperatorNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleOperatorNotFoundException(OperatorNotFoundException ex){
        ExceptionResponseDto operatorNotFoundResponceDto =new ExceptionResponseDto(ex.getMessage(), 400);

        return new ResponseEntity<>(operatorNotFoundResponceDto, HttpStatus.NOT_FOUND);
    }

}
