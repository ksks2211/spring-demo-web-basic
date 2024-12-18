package com.example.springdemowebbasic.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rival
 * @since 2024-11-15
 */
@RestController
@RequestMapping("/filter")
@Log4j2
public class FilterController {

    @GetMapping("")
    public String endpoint(){
        log.info("Filter Controller root");
        return "OK";
    }
}
