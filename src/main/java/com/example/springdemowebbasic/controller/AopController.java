package com.example.springdemowebbasic.controller;

import com.example.springdemowebbasic.annotation.LogRemoteAddr;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rival
 * @since 2024-11-15
 */
@RestController
@RequestMapping(value = "/aop", produces = MediaType.APPLICATION_JSON_VALUE)
public class AopController {



    @GetMapping("")
    public String logDuration(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "OK";

    }


    @GetMapping("/remote")
    @LogRemoteAddr
    public String logRemoteAddr(HttpServletRequest request){


        return request.getRemoteAddr();
    }
}
