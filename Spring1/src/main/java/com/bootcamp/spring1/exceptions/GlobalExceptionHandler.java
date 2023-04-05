package com.bootcamp.spring1.exceptions;


import com.bootcamp.spring1.dto.ValidationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdException.class)
    public ResponseEntity<ValidationDTO> IdException(IdException e){
        return ResponseEntity.status(404).body(
                ValidationDTO.builder()
                        .message(e.getMessage())
                        .action("BÚSQUEDA")
                        .build()
        );
    }

    @ExceptionHandler(RoomTypeException.class)
    public ResponseEntity<ValidationDTO> RoomTypeException(RoomTypeException e) {
        return ResponseEntity.status(404).body(
                ValidationDTO.builder()
                        .message(e.getMessage())
                        .action("BÚSQUEDA")
                        .build()
        );
    }
}
