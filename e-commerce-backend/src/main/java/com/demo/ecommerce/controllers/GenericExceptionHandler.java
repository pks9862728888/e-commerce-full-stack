package com.demo.ecommerce.controllers;

import com.demo.ecommerce.dao.ResponseDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MissingRequestValueException;

@RestControllerAdvice
@Slf4j
public class GenericExceptionHandler {

    @ExceptionHandler(MissingRequestValueException.class)
    public ResponseEntity<ResponseDao> handleBadRequestException(MissingRequestValueException e) {
        log.error("Bad request: {}", e.toString());
        return new ResponseEntity<>(ResponseDao.builder()
                .message(e.getMessage())
                .reason(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .build(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDao> handleGenericException(Exception e) {
        log.error("Internal server error: {}", e.toString());
        return new ResponseEntity<>(ResponseDao.builder()
                .message("Please contact support if the problem persists.")
                .reason(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
