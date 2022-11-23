package com.darden.userstory;

import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class ExceptionHandlerMain {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity CVEHandler(Exception e){
        return ResponseEntity.status(200).body("Category or Entry already exist");
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity PVEHandler(Exception e){
        return ResponseEntity.status(200).body("Essential Data must be added");
    }


}
