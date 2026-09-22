package dev.jabivullah.parking_lot_management_system.exception;

import dev.jabivullah.parking_lot_management_system.dto.ExceptionResponseDto;
import dev.jabivullah.parking_lot_management_system.exception.base.InvalidInputException;
import dev.jabivullah.parking_lot_management_system.exception.base.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleNotFound(ResourceNotFoundException ex){
        ExceptionResponseDto response = new ExceptionResponseDto(ex.getMessage(), 404);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ExceptionResponseDto> handleInvalidInput(InvalidInputException ex){
        ExceptionResponseDto response = new ExceptionResponseDto(ex.getMessage(), 400);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
