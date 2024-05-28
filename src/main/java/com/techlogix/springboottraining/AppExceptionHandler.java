package com.techlogix.springboottraining;

import com.techlogix.springboottraining.exception.DataNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgumentException(MethodArgumentNotValidException ex) {
        var errorHashMap = new HashMap<String, String>();
        ex.getBindingResult().getFieldErrors().forEach(err -> {
            errorHashMap.put(err.getField(), err.getDefaultMessage());
        });
        return errorHashMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataNotFoundException.class)
    public Map<String, String> handleDataNotFoundException(DataNotFoundException ex) {
        var errorHashMap = new HashMap<String, String>();
        errorHashMap.put("message", ex.getMessage());
        return errorHashMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public Map<String, String> handleBadRequestException(BadRequestException ex) {
        var errorHashMap = new HashMap<String, String>();
        errorHashMap.put("message", ex.getMessage());
        return errorHashMap;
    }

}
