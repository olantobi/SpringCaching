package com.myapp.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.myapp.service.impl.ContactServiceImpl;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger= LoggerFactory.getLogger(ContactServiceImpl.class);
	
	 @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        SpringCacheException errorMessage = new SpringCacheException(status.BAD_REQUEST,"My Error",ex);
	        return new ResponseEntity<Object>(errorMessage, headers, status);
	    }

//	    @Override
//	    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	        String unsupported = "Unsupported content type: " + ex.getContentType();
//	        String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
//	        ErrorMessage errorMessage = new ErrorMessage(unsupported, supported);
//	        return new ResponseEntity(errorMessage, headers, status);
//	    }
//
//	    @Override
//	    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	        Throwable mostSpecificCause = ex.getMostSpecificCause();
//	        ErrorMessage errorMessage;
//	        if (mostSpecificCause != null) {
//	            String exceptionName = mostSpecificCause.getClass().getName();
//	            String message = mostSpecificCause.getMessage();
//	            errorMessage = new ErrorMessage(exceptionName, message);
//	        } else {
//	            errorMessage = new ErrorMessage(ex.getMessage());
//	        }
//	        return new ResponseEntity(errorMessage, headers, status);
//	    }
	
	@ExceptionHandler(SpringCacheException.class)
	ResponseEntity<Object> handleBadRequests(HttpStatus status,String message,SpringCacheException ex) throws IOException  {
		SpringCacheException errorMessage = new SpringCacheException(status,message,ex.getLocalizedMessage());
        return new ResponseEntity<Object>(errorMessage,status);
	}
}
