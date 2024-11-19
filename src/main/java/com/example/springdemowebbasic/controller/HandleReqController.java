package com.example.springdemowebbasic.controller;

import com.example.springdemowebbasic.dto.LoginDto;
import com.example.springdemowebbasic.dto.QueryDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MissingServletRequestParameterException;
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
@Log4j2
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




    // query?id=10
    @GetMapping(value="/posts")
    public Map<String, Object> getPosts(@RequestParam(value="id") Long id){
        HashMap<String, Object> res = new HashMap<>();
        res.put("id",id);
        return res;
    }


    // page=10&size=20&query=nanana&keywords=
    @GetMapping(value="/query")
    public QueryDto getQuery(QueryDto query){
        return query;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        var res = new HashMap<String, Object>();

        res.put("status", HttpStatus.BAD_REQUEST.value());
        res.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());

        res.put("message", e.getMessage());
        res.put("exception", "MissingServletRequestParameterException");
        return res;
    }


    @GetMapping("/movies/{id}")
    public Map<String, Object> parsePathVariable(@PathVariable(name="id") @Min(10) Long movieId){
        var res = new HashMap<String, Object>();
        res.put("id", movieId);
        return res;
    }


    @GetMapping("/agent")
    public String readAgent(@RequestHeader(HttpHeaders.USER_AGENT) String userAgent){
        return userAgent;
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





    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/form")
    public LoginDto handleForm(@ModelAttribute LoginDto loginDto){
        return loginDto;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="body")
    public LoginDto handleBody(@RequestBody LoginDto loginDto){
        return loginDto;
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
