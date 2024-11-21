package com.example.springdemowebbasic.handler;

import com.example.springdemowebbasic.dto.ErrorResBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * @author rival
 * @since 2024-11-09
 */

@ControllerAdvice
public class CustomErrorHandler {




    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResBody handle404(NoResourceFoundException e){


        return ErrorResBody.builder()
            .error(HttpStatus.NOT_FOUND.getReasonPhrase())
            .message(e.getMessage())
            .path("/"+e.getResourcePath())
            .status(HttpStatus.NOT_FOUND.value())
            .build();

    }

}
