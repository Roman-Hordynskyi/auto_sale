package com.autosale.application.service.handler;

import com.autosale.application.model.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiException> handleEntityNotFoundExceptions(EntityNotFoundException ex) {
        String stacktrace = Arrays.toString(ex.getStackTrace());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildException(HttpStatus.NOT_FOUND, ex.getMessage(), stacktrace));
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ApiException> handleEntityAlreadyExistExceptions(EntityExistsException ex) {
        String stacktrace = Arrays.toString(ex.getStackTrace());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(buildException(HttpStatus.CONFLICT, ex.getMessage(), stacktrace));
    }

    private ApiException buildException(HttpStatus status, String errorMessage, String stacktrace) {
        return buildException(status, errorMessage, stacktrace, null);
    }

    private ApiException buildException(HttpStatus status, String errorMessage, String stacktrace, List<ApiException.Field> fields) {
        return new ApiException(status.value(), errorMessage, stacktrace, fields);
    }
}
