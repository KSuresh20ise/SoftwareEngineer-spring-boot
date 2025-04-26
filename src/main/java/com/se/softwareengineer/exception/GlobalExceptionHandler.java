package com.se.softwareengineer.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SoftwareEngineerExistsException.class)
    public ResponseEntity<String> SoftwareEngineerExistsException(SoftwareEngineerExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(SoftwareEngineerNotFound.class)
    public ResponseEntity<String> softwareEngineerNotFoundException(SoftwareEngineerNotFound ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
