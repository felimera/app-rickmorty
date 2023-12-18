package com.coderbyte.apprickmorty.infrastructure.controllers;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
//    @ExceptionHandler(value = RuntimeException.class)
//    public ResponseEntity<MessageDto> runtimeExceptionHandler(RuntimeException ex) {
//        MessageDto error = MessageDto.builder().code("500").message(ex.getMessage()).build();
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(value = BusinessException.class)
//    public ResponseEntity<MessageDto> businessExceptionHandler(BusinessException ex) {
//        MessageDto error = MessageDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
//        return new ResponseEntity<>(error, ex.getHttpStatus());
//    }
}
