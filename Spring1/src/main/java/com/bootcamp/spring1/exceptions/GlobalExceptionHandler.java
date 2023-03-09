package com.bootcamp.spring1.exceptions;


import com.bootcamp.spring1.dto.ValidationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    // AMBOS METODOS SIRVEN PARA CONVERTIR LOS MENSAJES DE LAS VALIDACIONES EN UN ARRAY DE MENSAJES ENTENDIBLES.

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationDTO> validationException(MethodArgumentNotValidException e){
        return ResponseEntity.status(400).body(
                new ValidationDTO(
                        e.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList())
                )
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationDTO> validationException(ConstraintViolationException e){
        return ResponseEntity.ok(
                new ValidationDTO(
                        e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
                )
        );
    }
}
