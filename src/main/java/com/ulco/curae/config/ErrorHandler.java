package com.ulco.curae.config;

import com.ulco.curae.dto.ErrorDTO;
import com.ulco.curae.exception.AlreadyExistsException;
import com.ulco.curae.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDTO handleNotFoundException(final NotFoundException e,
                                            final HttpServletRequest request){
        return ErrorDTO.builder()
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyExistsException.class)
    public ErrorDTO handleAldreadyExistsException(final AlreadyExistsException e,
                                            final HttpServletRequest request){
        return ErrorDTO.builder()
                .error(HttpStatus.CONFLICT.getReasonPhrase())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .status(HttpStatus.CONFLICT.value())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO handleMethodArgumentNotValidException(final MethodArgumentNotValidException e,
                                                          final HttpServletRequest request){
        final String message = e.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining());

        return ErrorDTO.builder()
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(message)
                .path(request.getRequestURI())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .build();
    }


//    @ExceptionHandler(ConstraintViolationException.class)
//    ResponseEntity<ErrorDTO> handleConstraintViolationException(ConstraintViolationException e) {
//        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
//    }

//    @ExceptionHandler(NotFoundException.class)
//    ResponseStatusException handleNotFoundException(NotFoundException e) {
//        return new ResponseStatusException(HttpStatus.NOT_FOUND, "La ressource est introuvable");
//    }
//
//    @ExceptionHandler(AlreadyExistsException.class)
//    ResponseStatusException handleAlreadyExistsException(AlreadyExistsException e) {
//        return new ResponseStatusException(HttpStatus.CONFLICT, "La ressource est déjà existante");
//    }

//    @ExceptionHandler(AlreadyExistsException.class)
//    ResponseEntity<ErrorDTO> handleAlreadyExistsException(AlreadyExistsException e) {
//        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.CONFLICT);
//    }

}