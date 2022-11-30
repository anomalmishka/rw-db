package org.example.controller.advice;

import org.example.dto.advice.AdviceExceptionDTO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.example.exception.ErrorTransaction;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class AdviceExceptionHandler extends ResponseEntityExceptionHandler {

    private AdviceExceptionDTO sendBodyException(String text, HttpStatus httpStatus) {
        return AdviceExceptionDTO.builder()
                .error(text)
                .httpStatus(httpStatus)
                .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                .path("lib-db")
                .build();
    }

    @ExceptionHandler(value = {EmptyResultDataAccessException.class})
    protected ResponseEntity<Object> handleEmptyResultDataAccessException(RuntimeException ex, WebRequest request) {
        String text = "The entered data is not correct. " + ex.getMessage();
        return handleExceptionInternal(
                ex,
                sendBodyException(text, HttpStatus.BAD_REQUEST),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }

    @ExceptionHandler(value = {ErrorInvalidData.class})
    protected ResponseEntity<Object> handleErrorInvalidData(RuntimeException ex, WebRequest request) {
        String text = "The entered data is not correct. " + ex.getMessage();
        return handleExceptionInternal(
                ex,
                sendBodyException(text, HttpStatus.BAD_REQUEST),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }

    @ExceptionHandler(value = {ErrorDataNotFound.class})
    protected ResponseEntity<Object> handleErrorDataNotFound(RuntimeException ex, WebRequest request) {
        String text = "The entered data is not found. " + ex.getMessage();
        return handleExceptionInternal(
                ex,
                sendBodyException(text, HttpStatus.NOT_FOUND),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request);
    }

    @ExceptionHandler(value = {ErrorTransaction.class})
    protected ResponseEntity<Object> handleErrorTransaction(RuntimeException ex, WebRequest request) {
        String text = "Error transaction. " + ex.getMessage();
        return handleExceptionInternal(
                ex,
                sendBodyException(text, HttpStatus.INTERNAL_SERVER_ERROR),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    protected ResponseEntity<Object> handleNullPointerException(RuntimeException ex, WebRequest request) {
        String text = "The entered data is not correct. " + ex.getMessage();
        return handleExceptionInternal(
                ex,
                sendBodyException(text, HttpStatus.BAD_REQUEST),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<Object> handleIllegalArgumentException(RuntimeException ex, WebRequest request) {
        String text = "The entered data is not correct. " + ex.getMessage();
        return handleExceptionInternal(
                ex,
                sendBodyException(text, HttpStatus.BAD_REQUEST),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    protected ResponseEntity<Object> handleNoSuchElementException(RuntimeException ex, WebRequest request) {
        String text = "The entered data is not correct. " + ex.getMessage();
        return handleExceptionInternal(
                ex,
                sendBodyException(text, HttpStatus.BAD_REQUEST),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }
}


