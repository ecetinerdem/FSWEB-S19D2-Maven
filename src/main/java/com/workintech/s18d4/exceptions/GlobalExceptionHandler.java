package com.workintech.s18d4.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<AccountErrorResponse> handleException(AccountException exception) {
        log.error("An Account error has occured ", exception);
        AccountErrorResponse accountErrorResponse = new AccountErrorResponse(exception.getHttpStatus().value(),exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(accountErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerException exception) {
        log.error("A Customer error has occured ", exception);
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(exception.getHttpStatus().value(),exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(customerErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<AddressErrorResponse> handleException(AddressException exception) {
        log.error("An Address error has occured ", exception);
        AddressErrorResponse addressErrorResponse = new AddressErrorResponse(exception.getHttpStatus().value(),exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(addressErrorResponse, exception.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> handleException(Exception exception) {
        log.error("An Exception has occured ", exception);
        GlobalErrorResponse customerErrorResponse = new GlobalErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(customerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
