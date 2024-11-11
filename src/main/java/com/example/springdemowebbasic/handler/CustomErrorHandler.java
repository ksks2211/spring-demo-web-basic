package com.example.springdemowebbasic.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rival
 * @since 2024-11-09
 */

@ControllerAdvice
public class CustomErrorHandler {


    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Map<String,Object> handle404(NoResourceFoundException e){
        var errorRes = new HashMap<String,Object>();
        errorRes.put("status", HttpStatus.NOT_FOUND.value());
        errorRes.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        errorRes.put("message", e.getMessage());
        return errorRes;

    }

}
