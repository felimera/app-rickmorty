package com.coderbyte.apprickmorty.infrastructure.controllers;

import com.coderbyte.apprickmorty.infrastructure.entities.MessageDto;
import com.coderbyte.apprickmorty.infrastructure.exception.BusinessException;
import com.coderbyte.apprickmorty.infrastructure.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<MessageDto> runtimeExceptionHandler(RuntimeException ex) {
        MessageDto error = MessageDto.builder().code("500").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<MessageDto> businessExceptionHandler(BusinessException ex) {
        MessageDto error = MessageDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<MessageDto> notFoundExceptionHandler(NotFoundException ex) {
        MessageDto error = MessageDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}
