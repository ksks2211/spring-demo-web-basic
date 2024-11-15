package com.example.springdemowebbasic.controller;

import com.example.springdemowebbasic.annotation.ClientRemoteAddr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rival
 * @since 2024-11-16
 */

@RestController
@RequestMapping(value="/resolver")
public class ResolverController {
    @GetMapping("")
    public String endpoint(@ClientRemoteAddr String remoteAddr){
        return remoteAddr;
    }
}
