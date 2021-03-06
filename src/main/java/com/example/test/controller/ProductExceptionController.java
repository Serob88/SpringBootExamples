package com.example.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

  @ExceptionHandler(value = ProductNotfoundException.class)
  public ResponseEntity<Object> exception(ProductNotfoundException exception) {
    return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);

  }

  @ExceptionHandler(value = AOPException.class)
  public ResponseEntity<Object> exception(AOPException exception) {
    return new ResponseEntity<>("Not serviced", HttpStatus.NOT_FOUND);

  }

  public static class ProductNotfoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
  }
  public static class AOPException extends RuntimeException {

    private static final long serialVersionUID = 1L;
  }
}
