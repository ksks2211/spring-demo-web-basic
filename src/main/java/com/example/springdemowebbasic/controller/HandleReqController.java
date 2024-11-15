package com.example.springdemowebbasic.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rival
 * @since 2024-11-11
 */


@RestController
@RequestMapping(value="/req", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
@Validated
public class HandleReqController {

    @GetMapping(value="/read-header")
    public Map<String,Object> getReqInfo(HttpServletRequest request){

        var res = new HashMap<String,Object>();


        String ipAddress = request.getHeader("X-Forwarded-For");
        String userAgent = request.getHeader("User-Agent");



        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = request.getRemoteAddr();
        }


        res.put("Ip", ipAddress);

        res.put("agent", userAgent);

        return res;

    }



    @GetMapping(value="/query")
    public Map<String, Object> getQuery(){

        return new HashMap<>();
    }


    @GetMapping("/movies/{id}")
    public Map<String, Object> parsePathVariable(@PathVariable(name="id") @Min(10) Long movieId){
        var res = new HashMap<String, Object>();
        res.put("id", movieId);
        return res;
    }
    // Fail to parse Path
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        var res = new HashMap<String, Object>();

        res.put("status", HttpStatus.BAD_REQUEST.value());
        res.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());

        res.put("message", e.getMessage());
        res.put("exception", "MethodArgumentTypeMismatchException");

        return res;
    }
    // Fail to validate Path
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleConstraintViolationException(ConstraintViolationException e){
        var res = new HashMap<String, Object>();

        res.put("status", HttpStatus.BAD_REQUEST.value());
        res.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());

        res.put("message", e.getMessage());
        res.put("exception", "ConstraintViolationException");


        return res;
    }






    @PostMapping(value = "/endpoint")
    public void postReq(){

    }

    @DeleteMapping(value="/endpoint")
    public void deleteReq(){

    }

    @PutMapping(value="/endpoint")
    public void putReq(){

    }


    @PatchMapping(value="/endpoint")
    public void patchReq() {

    }


}
