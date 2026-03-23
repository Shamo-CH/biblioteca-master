package com.example.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(
            MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidExceptionErrors(MethodArgumentNotValidException ex) {
        HashMap<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errores.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        return new ErrorResponse(
                400,
                "Error de validacion",
                errores
        );
    }


}
