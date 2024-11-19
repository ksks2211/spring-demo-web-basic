package com.example.springdemowebbasic.controller;

import com.example.springdemowebbasic.annotation.InterceptQuery;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rival
 * @since 2024-11-18
 */

@RestController
@RequestMapping("/interceptor")
@Log4j2
public class InterceptorController {


    // /interceptor?name=james
    @GetMapping("")
    @InterceptQuery("name")
    public String endpoint(){
        log.info("interceptor endpoint");
        return "OK";
    }
}
