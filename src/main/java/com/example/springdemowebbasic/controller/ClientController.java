package com.example.springdemowebbasic.controller;

import com.example.springdemowebbasic.dto.LoginDto;
import com.example.springdemowebbasic.dto.QueryDto;
import com.example.springdemowebbasic.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rival
 * @since 2024-11-21
 */

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final ApiService apiService;


    @GetMapping("")
    public LoginDto fetch(){
        log.info("Fetch Start!");
        LoginDto login = apiService.getLogin("username", "password");

        log.info("Fetch done!");
        return login;
    }

    
    @GetMapping("/query")
    public QueryDto query(QueryDto query){

        return apiService.getQueryDto(query);
    }





}
