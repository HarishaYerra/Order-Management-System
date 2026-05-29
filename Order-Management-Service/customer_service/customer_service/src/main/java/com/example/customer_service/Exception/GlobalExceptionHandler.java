package com.example.customer_service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ValidationException;

public class GlobalExceptionHandler {

	//Customer Not Found
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException ex){
		return new ResponseEntity<>(
			ex.getMessage(),
			HttpStatus.NOT_FOUND);
	}
	
	//Validation Exception
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> handleValidationException(ValidationException ex){
		return new ResponseEntity<>(
				ex.getMessage(),
				HttpStatus.BAD_REQUEST);
		}
	
	// Generic Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(
            Exception ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
