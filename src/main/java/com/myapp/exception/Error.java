package com.myapp.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@JsonSerialize
public class Error {
    @JsonProperty
    private String message;
    @JsonProperty
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    public Error() {
        timestamp=LocalDateTime.now();
    }
    public Error(String message, HttpStatus status) {
        this.timestamp=LocalDateTime.now();
        this.message = message;
        this.status = status;
    }
}
