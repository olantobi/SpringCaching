package com.myapp.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class SpringCacheException extends Exception{
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	public SpringCacheException(HttpStatus status, String message, String debugMessage) {
		super();
		this.setStatus(status);
		this.message = message;
		this.debugMessage = debugMessage;
	}
	public SpringCacheException() {
		timestamp = LocalDateTime.now();
	}
	
	public SpringCacheException(HttpStatus status) {
		this();
		this.setStatus(status);
	}

	public SpringCacheException(HttpStatus status, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage("Unexpected error");
		this.setDebugMessage(ex.getLocalizedMessage());
	}

	public SpringCacheException(HttpStatus status, String message, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage(message);
		this.setDebugMessage(ex.getLocalizedMessage());
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
