package com.workmotion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> employeeNotFoundHandler(EmployeeNotFoundException e){
        return  new ResponseEntity<>(new ExceptionResponse(e.getErrorCode(),e.getErrorMessage()), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = StateException.class)
    public ResponseEntity<ExceptionResponse> stateExceptionHandler(StateException e){
        return  new ResponseEntity<>(new ExceptionResponse(e.getErrorCode(),e.getErrorMessage()), HttpStatus.NOT_FOUND);
    }
}
