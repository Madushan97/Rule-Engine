package com.cba.Rule.Engine.controller;

import com.cba.Rule.Engine.exception.ClientErrorException;
import com.cba.Rule.Engine.exception.NotFoundException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

    @ControllerAdvice
    public class ExceptionControllerAdvice {
        private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler({MethodArgumentNotValidException.class})
        public ResponseEntity<String> validExceptionHandler(MethodArgumentNotValidException ex) {
            BindingResult result = ex.getBindingResult();
            FieldError error = result.getFieldError();
            String errorMessage = error != null ? error.getDefaultMessage() : ex.getMessage();
            LOGGER.error("ValidExceptionHandler : {}", ex.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler({HttpClientErrorException.class, ClientErrorException.class})
        public ResponseEntity<String> clientErrorExceptionHandler(Exception ex) {
            LOGGER.error("ClientErrorExceptionHandler : {}", ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ResponseStatus(HttpStatus.UNAUTHORIZED)
        @ExceptionHandler(AuthenticationException.class)
        public ResponseEntity<String> authenticationExceptionHandler(AuthenticationException ex) {
            LOGGER.error("AuthenticationExceptionHandler : {}", ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<String> notFoundExceptionHandler(NotFoundException ex) {
            LOGGER.error("NotFoundExceptionHandler : {}", ex.getMessage(), ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

    /*@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<String> notImplementedExceptionHandler(NotImplementedException ex) {
        LOGGER.error("NotImplementedExceptionHandler : " + ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_IMPLEMENTED);
    }*/

        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ExceptionHandler({Exception.class, HttpServerErrorException.class})
        public ResponseEntity<String> genericExceptionHandler(Exception ex) {
            LOGGER.error("GenericExceptionHandler : {}", ex.getMessage(), ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
