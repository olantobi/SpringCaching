/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.exception;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author olanrewaju.ebenezer
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        SpringCacheException errorMessage = new SpringCacheException(status.BAD_REQUEST, "My Error", ex);
        return new ResponseEntity<Object>(errorMessage, headers, status);
    }

    @ExceptionHandler(SpringCacheException.class)    
    ResponseEntity<Object> handleBadRequests(SpringCacheException ex) throws IOException {
        SpringCacheException errorMessage = new SpringCacheException(HttpStatus.BAD_REQUEST, "My Error", ex);
        return new ResponseEntity<Object>(ex, HttpStatus.BAD_REQUEST);
    }
}
