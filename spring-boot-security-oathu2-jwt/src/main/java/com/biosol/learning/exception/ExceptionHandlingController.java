package com.biosol.learning.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionHandlingController {

  @ExceptionHandler(ResourceConflictException.class)
  public ResponseEntity<ExceptionResponse> resourceConflict(ResourceConflictException ex) {
    ExceptionResponse response = new ExceptionResponse();
    response.setErrorCode("Conflict");
    response.setErrorMessage(ex.getMessage());
    return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
  }
}
