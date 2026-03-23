package com.example.biblioteca.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data

public class ErrorResponse {
    private int status;
    private String error;
    private LocalDateTime date;
    private Map<String, String> errores;

    public ErrorResponse(int status, String error, Map<String, String> errores) {
        this.status = status;
        this.error = error;
        this.errores = errores;
        date = LocalDateTime.now();
    }
}
