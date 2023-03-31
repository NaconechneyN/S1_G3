package com.bootcamp.spring1.exceptions;


import com.bootcamp.spring1.dto.ValidationDTO;
import com.bootcamp.spring1.dto.response.RunTimeExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
/*
    // AMBOS MÉTODOS SIRVEN PARA CONVERTIR LOS MENSAJES DE LAS VALIDACIONES EN UN ARRAY DE MENSAJES ENTENDIBLES.

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationDTO> validationException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(400).body(
                new ValidationDTO(
                        e.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList())
                )
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationDTO> validationException(ConstraintViolationException e) {
        return ResponseEntity.ok(
                new ValidationDTO(
                        e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
                )
        );
    }
*/
    ///Generar excepción de fecha (aca se manejan porque YA EXISTEN), probar que msj lanza y aca lo "editamos"
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RunTimeExceptionDto> validationException(RuntimeException e) {
        return ResponseEntity.status(400).body(
                new RunTimeExceptionDto(
                        e.getMessage()
                )
        );
    }
    @ExceptionHandler(IdException.class)
    public ResponseEntity<ValidationDTO> IdException(IdException e){
        return ResponseEntity.status(404).body(
                ValidationDTO.builder()
                        .message(e.getMessage())
                        .action("BÚSQUEDA")
                        .build()
        );
    }
}
