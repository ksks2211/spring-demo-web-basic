package com.example.springdemowebbasic.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author rival
 * @since 2024-11-20
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
@Setter
public class CustomBadRequestException extends RuntimeException {

    private String subMessage;
    public CustomBadRequestException(String message, String subMessage) {
        super(message);
        this.subMessage=subMessage;
    }
}
