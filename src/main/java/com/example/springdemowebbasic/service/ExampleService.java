package com.example.springdemowebbasic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author rival
 * @since 2024-11-09
 */
@Service
@RequiredArgsConstructor
public class ExampleService {

    public String getMessage(){
        return "Hello from example service";
    }


    public Integer generateRandInt(){
        Random random = new Random();
        // 0 ~ 99
        return random.nextInt(100);
    }
}
